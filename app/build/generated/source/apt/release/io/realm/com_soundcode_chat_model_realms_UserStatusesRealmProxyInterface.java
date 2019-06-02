package io.realm;


public interface com_soundcode_chat_model_realms_UserStatusesRealmProxyInterface {
    public String realmGet$userId();
    public void realmSet$userId(String value);
    public long realmGet$lastStatusTimestamp();
    public void realmSet$lastStatusTimestamp(long value);
    public com.soundcode.chat.model.realms.User realmGet$user();
    public void realmSet$user(com.soundcode.chat.model.realms.User value);
    public RealmList<com.soundcode.chat.model.realms.Status> realmGet$statuses();
    public void realmSet$statuses(RealmList<com.soundcode.chat.model.realms.Status> value);
    public boolean realmGet$areAllSeen();
    public void realmSet$areAllSeen(boolean value);
}
