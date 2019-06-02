package com.soundcode.chat.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soundcode.chat.R;
import com.soundcode.chat.activities.settings.new_settings.SettingsAct;
import com.soundcode.chat.adapters.ChatsAdapter;
import com.soundcode.chat.adapters.ViewPagerAdapter;
import com.soundcode.chat.fragments.BaseFragment;
import com.soundcode.chat.fragments.CallsFragment;
import com.soundcode.chat.fragments.FeedFragment;
import com.soundcode.chat.fragments.FragmentChats;
import com.soundcode.chat.fragments.StatusFragment;
import com.soundcode.chat.interfaces.FragmentCallback;
import com.soundcode.chat.interfaces.StatusFragmentCallbacks;
import com.soundcode.chat.job.DeleteStatusJob;
import com.soundcode.chat.job.SaveTokenJob;
import com.soundcode.chat.job.SetLastSeenJob;
import com.soundcode.chat.job.SyncContactsDailyJob;
import com.soundcode.chat.model.constants.GroupEventTypes;
import com.soundcode.chat.model.realms.Chat;
import com.soundcode.chat.model.realms.GroupEvent;
import com.soundcode.chat.model.realms.Status;
import com.soundcode.chat.model.realms.User;
import com.soundcode.chat.services.CallingService;
import com.soundcode.chat.services.FCMRegistrationService;
import com.soundcode.chat.services.InternetConnectedListener;
import com.soundcode.chat.services.NetworkService;
import com.soundcode.chat.utils.AppVerUtil;
import com.soundcode.chat.utils.DpUtil;
import com.soundcode.chat.utils.FabRotationAnimation;
import com.soundcode.chat.utils.FireConstants;
import com.soundcode.chat.utils.FireListener;
import com.soundcode.chat.utils.FireManager;
import com.soundcode.chat.utils.GroupManager;
import com.soundcode.chat.utils.IntentUtils;
import com.soundcode.chat.utils.NetworkHelper;
import com.soundcode.chat.utils.RealmHelper;
import com.soundcode.chat.utils.ServiceHelper;
import com.soundcode.chat.utils.SharedPreferencesManager;
import com.soundcode.chat.utils.TimeHelper;
import com.soundcode.chat.utils.UnProcessedJobs;
import com.soundcode.chat.utils.Util;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements FabRotationAnimation.RotateAnimationListener, FragmentCallback, StatusFragmentCallbacks {
    private static final int CAMERA_REQUEST = 9514;
    public boolean isInActionMode = false;
    FabRotationAnimation rotationAnimation;
    private boolean isInSearchMode = false;
    private BottomSheetDialog bottomSheetDialog;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private TextView tvSelectedChatCount;
    private SearchView searchView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<User> users;
    private FireListener fireListener;
    private ViewPagerAdapter adapter;
    private int currentPage = 0;

    public boolean isInActionMode() {
        return isInActionMode;
    }

    @Override
    boolean enablePresence() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        setSupportActionBar(toolbar);

        rotationAnimation = new FabRotationAnimation(this);

        fireListener = new FireListener();
        startServices();
        bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet_create_new, null);
        bottomSheetDialog.setContentView(view);
        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) ((View) view.getParent())
                .getLayoutParams();
        ((View) view.getParent()).setLayoutParams(layoutParams);
        LinearLayout newChat = view.findViewById(R.id.createChat);
        LinearLayout newGroup = view.findViewById(R.id.createGroup);
        newChat.setOnClickListener(view12 -> startActivity(new Intent(MainActivity.this, NewChatActivity.class)));
        newGroup.setOnClickListener(view1 -> createGroupClicked());
        users = RealmHelper.getInstance().getListOfUsers();

        fab.setOnClickListener(view13 -> {
            switch (currentPage) {
                case 0:
//                        startActivity(new Intent(MainActivity.this, NewChatActivity.class));
                    bottomSheetDialog.show();
                    break;
                case 1:
                    startCamera();
                    break;

                case 2:
                    startActivity(new Intent(MainActivity.this, NewCallActivity.class));
                    break;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            //onSwipe or tab change
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                if (isInSearchMode)
                    exitSearchMode();
                if (isInActionMode)
                    exitActionMode();
                switch (position) {


                    //add margin to fab when tab is changed only if ads are shown
                    //animate fab with rotation animation also
                    case 0:
                        if (adapter.getItem(0) != null) {
                            BaseFragment fragment = (BaseFragment) adapter.getItem(0);
                            addMarginToFab(fragment.isVisible() && fragment.isAdShowing());
                        }
                        animateFab(R.drawable.new_msg_icon);

                        break;
                    case 1:
                        if (adapter.getItem(1) != null) {
                            BaseFragment fragment = (BaseFragment) adapter.getItem(1);
                            addMarginToFab(fragment.isVisible() && fragment.isAdShowing());
                        }
                        animateFab(R.drawable.ic_photo_camera);

                        break;

                    default:

                        if (adapter.getItem(2) != null) {
                            BaseFragment fragment = (BaseFragment) adapter.getItem(2);
                            addMarginToFab(fragment.isVisible() && fragment.isAdShowing());
                        }
                        animateFab(R.drawable.ic_phone);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

        //save app ver if it's not saved before
        if (!SharedPreferencesManager.isAppVersionSaved()) {
            FireConstants.usersRef.child(FireManager.getUid()).child("ver").setValue(AppVerUtil.getAppVersion(this)).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    SharedPreferencesManager.setAppVersionSaved(true);
                }
            });
        }


        //start sinch client for the first time to save the id and start receiving calls
        if (!SharedPreferencesManager.isSinchConfigured()) {
            Intent serviceIntent = new Intent(this, CallingService.class);
            serviceIntent.putExtra(IntentUtils.START_SINCH, true);
            startService(serviceIntent);
        }


        //Fetch current user statuses
        fetchStatuses();


    }


    //start CameraActivity
    private void startCamera() {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(IntentUtils.CAMERA_VIEW_SHOW_PICK_IMAGE_BUTTON, true);
        intent.putExtra(IntentUtils.IS_STATUS, true);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    //animate FAB with rotation animation
    private void animateFab(final int drawable) {
        RotateAnimation animation = rotationAnimation.start(drawable);
        fab.startAnimation(animation);
    }


    private void fetchStatuses() {
        //add all statuses to this list to delete deleted statuses if needed
        final List<String> statusesIds = new ArrayList<>();
        //get current time before 24 hours (Yesterday)
        long timeBefore24Hours = TimeHelper.getTimeBefore24Hours();
        //get all user statuses that are not passed 24 hours

        for (User user : users) {
            Query query = FireConstants.statusRef.child(user.getUid())
                    .orderByChild("timestamp")
                    .startAt(timeBefore24Hours);

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() != null) {
                        //get every status
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String userId = snapshot.getRef().getParent().getKey();
                            String statusId = snapshot.getKey();
                            Status status = snapshot.getValue(Status.class);
                            status.setStatusId(statusId);
                            status.setUserId(userId);

                            statusesIds.add(statusId);
                            //check if status is exists in local database , if not save it
                            if (RealmHelper.getInstance().getStatus(status.getStatusId()) == null) {
                                RealmHelper.getInstance().saveStatus(userId, status);
                                //schedule a job after 24 hours to delete this status locally
                                DeleteStatusJob.schedule(userId, statusId);
                                //update status fragment with the status
                                if (adapter != null && adapter.getItem(1) != null) {
                                    StatusFragment statusFragment = (StatusFragment) adapter.getItem(1);
                                    statusFragment.statusInserted();
                                }
                            }

                        }

                    } else {
                        //delete the statuses that the user has deleted
                        RealmHelper.getInstance().deleteDeletedStatusesLocally(statusesIds);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }


    private void startServices() {
        if (!Util.isOreoOrAbove()) {
            startService(new Intent(this, NetworkService.class));
            startService(new Intent(this, InternetConnectedListener.class));
            startService(new Intent(this, FCMRegistrationService.class));

        } else {
            if (!SharedPreferencesManager.isTokenSaved())
                SaveTokenJob.schedule(this, null);

            SetLastSeenJob.schedule(this);
            UnProcessedJobs.process(this);
        }

        //sync contacts for the first time
        if (!SharedPreferencesManager.isContactSynced()) {
            ServiceHelper.startSyncContacts(MainActivity.this);
        }

        //schedule daily job to sync contacts
        SyncContactsDailyJob.schedule();


    }


    private void init() {
        fab = findViewById(R.id.open_new_chat_fab);
        toolbar = findViewById(R.id.toolbar);
        tvSelectedChatCount = findViewById(R.id.tv_selected_chat);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        initTabLayout();

        //prefix for a bug in older APIs
        fab.bringToFront();
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentChats());
        adapter.addFragment(new StatusFragment());
        adapter.addFragment(new CallsFragment());
        //adapter.addFragment(new FeedFragment());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        setTabsTitles(3);
    }


    @Override
    protected void onPause() {
        super.onPause();
        fireListener.cleanup();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.search_item);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            //submit search for the current active fragment
            @Override
            public boolean onQueryTextChange(String newText) {
                BaseFragment chatsFragment = (BaseFragment) adapter.getItem(currentPage);
                if (chatsFragment != null) {
                    chatsFragment.onQueryTextChange(newText);
                }

                return false;
            }

        });
        //revert back to original adapter
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                exitSearchMode();
                return true;
            }
        });

        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            //exit search mode on searchClosed
            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                exitSearchMode();
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_delete:
                deleteItemClicked();
                break;

            case R.id.menu_item_mute:
                muteItemClicked();
                break;
            case R.id.settings_item:
                settingsItemClicked();
                break;

            case R.id.search_item:
                searchItemClicked();
                break;

            case R.id.new_group_item:
                createGroupClicked();
                break;


            case R.id.exit_group_item:
                exitGroupClicked();
                break;

            case R.id.invite_item:
                startActivity(IntentUtils.getShareAppIntent(MainActivity.this));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void exitGroupClicked() {
        if (!NetworkHelper.isConnected(this))
            return;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirmation)
                .setMessage(R.string.exit_group)
                .setNegativeButton(R.string.no, null)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (final Chat chat : getAdapter().getSelectedChatForActionMode()) {
                            GroupManager.exitGroup(chat.getChatId(), FireManager.getUid(), new GroupManager.OnComplete() {
                                @Override
                                public void onComplete(boolean isSuccessful) {
                                    RealmHelper.getInstance().exitGroup(chat.getChatId());
                                    GroupEvent groupEvent = new GroupEvent(SharedPreferencesManager.getPhoneNumber(), GroupEventTypes.USER_LEFT_GROUP, null);
                                    groupEvent.createGroupEvent(chat.getUser(), null);

                                }
                            });
                        }
                        exitActionMode();
                    }
                })
                .show();


    }

    private void createGroupClicked() {
        startActivity(new Intent(this, NewGroupActivity.class));
    }

    private void searchItemClicked() {
        if (isInActionMode)
            exitActionMode();

        isInSearchMode = true;


    }

    private void updateMutedIcon(MenuItem menuItem, boolean isMuted) {
        if (menuItem != null)
            menuItem.setIcon(isMuted ? R.drawable.ic_volume_up : R.drawable.ic_volume_off);
    }

    private void settingsItemClicked() {
        Intent intent = new Intent(this, SettingsAct.class);
        startActivity(intent);
    }

    private void muteItemClicked() {

        for (Chat chat : getAdapter().getSelectedChatForActionMode()) {
            if (chat.isMuted()) {
                RealmHelper.getInstance().setMuted(chat.getChatId(), false);
            } else {
                RealmHelper.getInstance().setMuted(chat.getChatId(), true);
            }
        }

        exitActionMode();
    }

    private void deleteItemClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirmation)
                .setMessage(R.string.delete_conversation_confirmation)
                .setNegativeButton(R.string.no, null)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (Chat chat : getAdapter().getSelectedChatForActionMode()) {
                            RealmHelper.getInstance().deleteChat(chat.getChatId());
                        }
                        exitActionMode();
                    }
                })
                .show();

    }


    public void addItemToActionMode(int itemsCount) {

        tvSelectedChatCount.setText(itemsCount + "");


        if (itemsCount > 1) {
            if (isHasMutedItem())
                setMenuItemVisibility(false);
                //if there is no muted item then the user may select multiple chats and mute them all in once
            else
                updateMutedIcon(toolbar.getMenu().findItem(R.id.menu_item_mute), false);


        } else if (itemsCount == 1) {
            ChatsAdapter adapter = getAdapter();
            if (adapter != null) {
                boolean isMuted = adapter.getSelectedChatForActionMode().get(0).isMuted();
                //in case if it's hidden before
                setMenuItemVisibility(true);
                updateMutedIcon(toolbar.getMenu().findItem(R.id.menu_item_mute), isMuted);
            }
        }

        updateGroupItems();
    }


    private void setMenuItemVisibility(boolean b) {
        if (toolbar.getMenu() != null && toolbar.getMenu().findItem(R.id.menu_item_mute) != null)
            toolbar.getMenu().findItem(R.id.menu_item_mute).setVisible(b);
    }

    private boolean isHasMutedItem() {
        for (Chat chat : getAdapter().getSelectedChatForActionMode()) {
            if (chat.isMuted())
                return true;
        }
        return false;
    }

    private boolean isHasGroupItem() {
        for (Chat chat : getAdapter().getSelectedChatForActionMode()) {
            User user = chat.getUser();
            if (user.isGroupBool() && user.getGroup().isActive())
                return true;
        }
        return false;
    }

    private boolean areAllOfChatsGroups() {

        boolean b = false;

        for (Chat chat : getAdapter().getSelectedChatForActionMode()) {
            User user = chat.getUser();
            if (user.isGroupBool() && user.getGroup().isActive())
                b = true;
            else {
                return false;
            }
        }

        return b;

    }


    public void onActionModeStarted() {
        if (isInSearchMode)
            exitSearchMode();

        if (!isInActionMode) {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.menu_action_chat_list);
        }

        if (getAdapter() != null)
            updateMutedIcon(toolbar.getMenu().findItem(R.id.menu_item_mute), getAdapter().getSelectedChatForActionMode().get(0).isMuted());

        updateGroupItems();

        isInActionMode = true;

        tvSelectedChatCount.setVisibility(View.VISIBLE);

    }

    private void updateGroupItems() {
        MenuItem deleteItem = toolbar.getMenu().findItem(R.id.menu_item_delete);
        if (deleteItem != null) {
            if (isHasGroupItem()) {
                toolbar.getMenu().findItem(R.id.menu_item_delete).setVisible(false);
                if (areAllOfChatsGroups())
                    toolbar.getMenu().findItem(R.id.exit_group_item).setVisible(true);
                else
                    toolbar.getMenu().findItem(R.id.exit_group_item).setVisible(false);
            } else {
                toolbar.getMenu().findItem(R.id.menu_item_delete).setVisible(true);

            }
        }
    }

    public void exitActionMode() {
        getAdapter().exitActionMode();
        isInActionMode = false;
        tvSelectedChatCount.setVisibility(View.GONE);
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_main);
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed() {
        if (isInActionMode)
            exitActionMode();
        else if (isInSearchMode)
            exitSearchMode();
        else {
            CallsFragment callsFragment = (CallsFragment) adapter.getItem(2);
            if (callsFragment != null && !callsFragment.isActionModeNull())
                callsFragment.exitActionMode();

            else
                super.onBackPressed();
        }


    }

    //start user profile (Dialog-Like Activity)
    public void userProfileClicked(User user) {
        Intent intent = new Intent(this, ProfilePhotoDialog.class);
        intent.putExtra(IntentUtils.UID, user.getUid());
        startActivity(intent);
    }

    public void exitSearchMode() {
        isInSearchMode = false;
        BaseFragment baseFragment = (BaseFragment) adapter.getItem(currentPage);
        if (baseFragment != null)
            baseFragment.onSearchClose();
    }


    private void setTabsTitles(int tabsSize) {
        for (int i = 0; i < tabsSize; i++) {
            switch (i) {

                case 0:
                    tabLayout.getTabAt(i).setText(R.string.chats);

                    break;

                case 1:
                    tabLayout.getTabAt(i).setText(R.string.status);
                    break;

                case 2:
                    tabLayout.getTabAt(i).setText(R.string.calls);
                    break;
                case 3:
                    tabLayout.getTabAt(i).setText(R.string.feed);
                    break;
            }
        }

    }

    private ChatsAdapter getAdapter() {
        if (adapter == null) return null;
        FragmentChats fragmentChats = (FragmentChats) adapter.getItem(0);
        return fragmentChats.getAdapter();
    }

    @Override
    public void onRotationAnimationEnd(int drawable) {
        fab.setImageResource(drawable);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            StatusFragment statusFragment = (StatusFragment) adapter.getItem(1);
            if (statusFragment != null) {
                statusFragment.onCameraActivityResult(resultCode, data);
            }
        }
    }

    @Override
    public void addMarginToFab(boolean isAdShowing) {

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        float v = isAdShowing ? DpUtil.toPixel(95, this) : getResources().getDimensionPixelSize(R.dimen.fab_margin);

        layoutParams.bottomMargin = (int) v;

        fab.setLayoutParams(layoutParams);


    }

    @Override
    public void openCamera() {
        startCamera();
    }

    @Override
    public void startTheActionMode(ActionMode.Callback callback) {
        startActionMode(callback);
    }

}




