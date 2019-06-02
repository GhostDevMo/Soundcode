package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_soundcode_chat_model_realms_QuotedMessageRealmProxy extends com.soundcode.chat.model.realms.QuotedMessage
    implements RealmObjectProxy, com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface {

    static final class QuotedMessageColumnInfo extends ColumnInfo {
        long messageIdIndex;
        long fromIdIndex;
        long fromPhoneIndex;
        long toIdIndex;
        long typeIndex;
        long contentIndex;
        long metadataIndex;
        long mediaDurationIndex;
        long thumbIndex;
        long fileSizeIndex;
        long contactIndex;
        long locationIndex;

        QuotedMessageColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("QuotedMessage");
            this.messageIdIndex = addColumnDetails("messageId", "messageId", objectSchemaInfo);
            this.fromIdIndex = addColumnDetails("fromId", "fromId", objectSchemaInfo);
            this.fromPhoneIndex = addColumnDetails("fromPhone", "fromPhone", objectSchemaInfo);
            this.toIdIndex = addColumnDetails("toId", "toId", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.contentIndex = addColumnDetails("content", "content", objectSchemaInfo);
            this.metadataIndex = addColumnDetails("metadata", "metadata", objectSchemaInfo);
            this.mediaDurationIndex = addColumnDetails("mediaDuration", "mediaDuration", objectSchemaInfo);
            this.thumbIndex = addColumnDetails("thumb", "thumb", objectSchemaInfo);
            this.fileSizeIndex = addColumnDetails("fileSize", "fileSize", objectSchemaInfo);
            this.contactIndex = addColumnDetails("contact", "contact", objectSchemaInfo);
            this.locationIndex = addColumnDetails("location", "location", objectSchemaInfo);
        }

        QuotedMessageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new QuotedMessageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final QuotedMessageColumnInfo src = (QuotedMessageColumnInfo) rawSrc;
            final QuotedMessageColumnInfo dst = (QuotedMessageColumnInfo) rawDst;
            dst.messageIdIndex = src.messageIdIndex;
            dst.fromIdIndex = src.fromIdIndex;
            dst.fromPhoneIndex = src.fromPhoneIndex;
            dst.toIdIndex = src.toIdIndex;
            dst.typeIndex = src.typeIndex;
            dst.contentIndex = src.contentIndex;
            dst.metadataIndex = src.metadataIndex;
            dst.mediaDurationIndex = src.mediaDurationIndex;
            dst.thumbIndex = src.thumbIndex;
            dst.fileSizeIndex = src.fileSizeIndex;
            dst.contactIndex = src.contactIndex;
            dst.locationIndex = src.locationIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private QuotedMessageColumnInfo columnInfo;
    private ProxyState<com.soundcode.chat.model.realms.QuotedMessage> proxyState;

    com_soundcode_chat_model_realms_QuotedMessageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (QuotedMessageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.soundcode.chat.model.realms.QuotedMessage>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$messageId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.messageIdIndex);
    }

    @Override
    public void realmSet$messageId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.messageIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.messageIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.messageIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.messageIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fromId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromIdIndex);
    }

    @Override
    public void realmSet$fromId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fromPhone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromPhoneIndex);
    }

    @Override
    public void realmSet$fromPhone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromPhoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromPhoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromPhoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromPhoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$toId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.toIdIndex);
    }

    @Override
    public void realmSet$toId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.toIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.toIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.toIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.toIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$metadata() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metadataIndex);
    }

    @Override
    public void realmSet$metadata(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metadataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metadataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metadataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metadataIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mediaDuration() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mediaDurationIndex);
    }

    @Override
    public void realmSet$mediaDuration(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mediaDurationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mediaDurationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mediaDurationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mediaDurationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbIndex);
    }

    @Override
    public void realmSet$thumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fileSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fileSizeIndex);
    }

    @Override
    public void realmSet$fileSize(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fileSizeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fileSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fileSizeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fileSizeIndex, value);
    }

    @Override
    public com.soundcode.chat.model.realms.RealmContact realmGet$contact() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.contactIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.soundcode.chat.model.realms.RealmContact.class, proxyState.getRow$realm().getLink(columnInfo.contactIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$contact(com.soundcode.chat.model.realms.RealmContact value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("contact")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.contactIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.contactIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.contactIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.contactIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.soundcode.chat.model.realms.RealmLocation realmGet$location() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.locationIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.soundcode.chat.model.realms.RealmLocation.class, proxyState.getRow$realm().getLink(columnInfo.locationIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$location(com.soundcode.chat.model.realms.RealmLocation value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("location")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.locationIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.locationIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.locationIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.locationIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("QuotedMessage", 12, 0);
        builder.addPersistedProperty("messageId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fromId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fromPhone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("toId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("metadata", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mediaDuration", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fileSize", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("contact", RealmFieldType.OBJECT, "RealmContact");
        builder.addPersistedLinkProperty("location", RealmFieldType.OBJECT, "RealmLocation");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static QuotedMessageColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new QuotedMessageColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "QuotedMessage";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "QuotedMessage";
    }

    @SuppressWarnings("cast")
    public static com.soundcode.chat.model.realms.QuotedMessage createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        if (json.has("contact")) {
            excludeFields.add("contact");
        }
        if (json.has("location")) {
            excludeFields.add("location");
        }
        com.soundcode.chat.model.realms.QuotedMessage obj = realm.createObjectInternal(com.soundcode.chat.model.realms.QuotedMessage.class, true, excludeFields);

        final com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface objProxy = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) obj;
        if (json.has("messageId")) {
            if (json.isNull("messageId")) {
                objProxy.realmSet$messageId(null);
            } else {
                objProxy.realmSet$messageId((String) json.getString("messageId"));
            }
        }
        if (json.has("fromId")) {
            if (json.isNull("fromId")) {
                objProxy.realmSet$fromId(null);
            } else {
                objProxy.realmSet$fromId((String) json.getString("fromId"));
            }
        }
        if (json.has("fromPhone")) {
            if (json.isNull("fromPhone")) {
                objProxy.realmSet$fromPhone(null);
            } else {
                objProxy.realmSet$fromPhone((String) json.getString("fromPhone"));
            }
        }
        if (json.has("toId")) {
            if (json.isNull("toId")) {
                objProxy.realmSet$toId(null);
            } else {
                objProxy.realmSet$toId((String) json.getString("toId"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                objProxy.realmSet$content(null);
            } else {
                objProxy.realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("metadata")) {
            if (json.isNull("metadata")) {
                objProxy.realmSet$metadata(null);
            } else {
                objProxy.realmSet$metadata((String) json.getString("metadata"));
            }
        }
        if (json.has("mediaDuration")) {
            if (json.isNull("mediaDuration")) {
                objProxy.realmSet$mediaDuration(null);
            } else {
                objProxy.realmSet$mediaDuration((String) json.getString("mediaDuration"));
            }
        }
        if (json.has("thumb")) {
            if (json.isNull("thumb")) {
                objProxy.realmSet$thumb(null);
            } else {
                objProxy.realmSet$thumb((String) json.getString("thumb"));
            }
        }
        if (json.has("fileSize")) {
            if (json.isNull("fileSize")) {
                objProxy.realmSet$fileSize(null);
            } else {
                objProxy.realmSet$fileSize((String) json.getString("fileSize"));
            }
        }
        if (json.has("contact")) {
            if (json.isNull("contact")) {
                objProxy.realmSet$contact(null);
            } else {
                com.soundcode.chat.model.realms.RealmContact contactObj = com_soundcode_chat_model_realms_RealmContactRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("contact"), update);
                objProxy.realmSet$contact(contactObj);
            }
        }
        if (json.has("location")) {
            if (json.isNull("location")) {
                objProxy.realmSet$location(null);
            } else {
                com.soundcode.chat.model.realms.RealmLocation locationObj = com_soundcode_chat_model_realms_RealmLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("location"), update);
                objProxy.realmSet$location(locationObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.soundcode.chat.model.realms.QuotedMessage createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.soundcode.chat.model.realms.QuotedMessage obj = new com.soundcode.chat.model.realms.QuotedMessage();
        final com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface objProxy = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("messageId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$messageId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$messageId(null);
                }
            } else if (name.equals("fromId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fromId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fromId(null);
                }
            } else if (name.equals("fromPhone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fromPhone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fromPhone(null);
                }
            } else if (name.equals("toId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$toId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$toId(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("content")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$content((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$content(null);
                }
            } else if (name.equals("metadata")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metadata((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metadata(null);
                }
            } else if (name.equals("mediaDuration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mediaDuration((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mediaDuration(null);
                }
            } else if (name.equals("thumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumb(null);
                }
            } else if (name.equals("fileSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fileSize((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fileSize(null);
                }
            } else if (name.equals("contact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$contact(null);
                } else {
                    com.soundcode.chat.model.realms.RealmContact contactObj = com_soundcode_chat_model_realms_RealmContactRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$contact(contactObj);
                }
            } else if (name.equals("location")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$location(null);
                } else {
                    com.soundcode.chat.model.realms.RealmLocation locationObj = com_soundcode_chat_model_realms_RealmLocationRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$location(locationObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.soundcode.chat.model.realms.QuotedMessage copyOrUpdate(Realm realm, com.soundcode.chat.model.realms.QuotedMessage object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.soundcode.chat.model.realms.QuotedMessage) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.soundcode.chat.model.realms.QuotedMessage copy(Realm realm, com.soundcode.chat.model.realms.QuotedMessage newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.soundcode.chat.model.realms.QuotedMessage) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.soundcode.chat.model.realms.QuotedMessage realmObject = realm.createObjectInternal(com.soundcode.chat.model.realms.QuotedMessage.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface realmObjectSource = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) newObject;
        com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface realmObjectCopy = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$messageId(realmObjectSource.realmGet$messageId());
        realmObjectCopy.realmSet$fromId(realmObjectSource.realmGet$fromId());
        realmObjectCopy.realmSet$fromPhone(realmObjectSource.realmGet$fromPhone());
        realmObjectCopy.realmSet$toId(realmObjectSource.realmGet$toId());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$content(realmObjectSource.realmGet$content());
        realmObjectCopy.realmSet$metadata(realmObjectSource.realmGet$metadata());
        realmObjectCopy.realmSet$mediaDuration(realmObjectSource.realmGet$mediaDuration());
        realmObjectCopy.realmSet$thumb(realmObjectSource.realmGet$thumb());
        realmObjectCopy.realmSet$fileSize(realmObjectSource.realmGet$fileSize());

        com.soundcode.chat.model.realms.RealmContact contactObj = realmObjectSource.realmGet$contact();
        if (contactObj == null) {
            realmObjectCopy.realmSet$contact(null);
        } else {
            com.soundcode.chat.model.realms.RealmContact cachecontact = (com.soundcode.chat.model.realms.RealmContact) cache.get(contactObj);
            if (cachecontact != null) {
                realmObjectCopy.realmSet$contact(cachecontact);
            } else {
                realmObjectCopy.realmSet$contact(com_soundcode_chat_model_realms_RealmContactRealmProxy.copyOrUpdate(realm, contactObj, update, cache));
            }
        }

        com.soundcode.chat.model.realms.RealmLocation locationObj = realmObjectSource.realmGet$location();
        if (locationObj == null) {
            realmObjectCopy.realmSet$location(null);
        } else {
            com.soundcode.chat.model.realms.RealmLocation cachelocation = (com.soundcode.chat.model.realms.RealmLocation) cache.get(locationObj);
            if (cachelocation != null) {
                realmObjectCopy.realmSet$location(cachelocation);
            } else {
                realmObjectCopy.realmSet$location(com_soundcode_chat_model_realms_RealmLocationRealmProxy.copyOrUpdate(realm, locationObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.soundcode.chat.model.realms.QuotedMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.soundcode.chat.model.realms.QuotedMessage.class);
        long tableNativePtr = table.getNativePtr();
        QuotedMessageColumnInfo columnInfo = (QuotedMessageColumnInfo) realm.getSchema().getColumnInfo(com.soundcode.chat.model.realms.QuotedMessage.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$messageId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$messageId();
        if (realmGet$messageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
        }
        String realmGet$fromId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromId();
        if (realmGet$fromId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
        }
        String realmGet$fromPhone = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromPhone();
        if (realmGet$fromPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
        }
        String realmGet$toId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$toId();
        if (realmGet$toId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$content = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$metadata = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$metadata();
        if (realmGet$metadata != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
        }
        String realmGet$mediaDuration = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$mediaDuration();
        if (realmGet$mediaDuration != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
        }
        String realmGet$thumb = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$thumb();
        if (realmGet$thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
        }
        String realmGet$fileSize = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fileSize();
        if (realmGet$fileSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
        }

        com.soundcode.chat.model.realms.RealmContact contactObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$contact();
        if (contactObj != null) {
            Long cachecontact = cache.get(contactObj);
            if (cachecontact == null) {
                cachecontact = com_soundcode_chat_model_realms_RealmContactRealmProxy.insert(realm, contactObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
        }

        com.soundcode.chat.model.realms.RealmLocation locationObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_soundcode_chat_model_realms_RealmLocationRealmProxy.insert(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.soundcode.chat.model.realms.QuotedMessage.class);
        long tableNativePtr = table.getNativePtr();
        QuotedMessageColumnInfo columnInfo = (QuotedMessageColumnInfo) realm.getSchema().getColumnInfo(com.soundcode.chat.model.realms.QuotedMessage.class);
        com.soundcode.chat.model.realms.QuotedMessage object = null;
        while (objects.hasNext()) {
            object = (com.soundcode.chat.model.realms.QuotedMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$messageId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$messageId();
            if (realmGet$messageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
            }
            String realmGet$fromId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromId();
            if (realmGet$fromId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
            }
            String realmGet$fromPhone = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromPhone();
            if (realmGet$fromPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
            }
            String realmGet$toId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$toId();
            if (realmGet$toId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$content = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            }
            String realmGet$metadata = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$metadata();
            if (realmGet$metadata != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
            }
            String realmGet$mediaDuration = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$mediaDuration();
            if (realmGet$mediaDuration != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
            }
            String realmGet$thumb = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$thumb();
            if (realmGet$thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
            }
            String realmGet$fileSize = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fileSize();
            if (realmGet$fileSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
            }

            com.soundcode.chat.model.realms.RealmContact contactObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$contact();
            if (contactObj != null) {
                Long cachecontact = cache.get(contactObj);
                if (cachecontact == null) {
                    cachecontact = com_soundcode_chat_model_realms_RealmContactRealmProxy.insert(realm, contactObj, cache);
                }
                table.setLink(columnInfo.contactIndex, rowIndex, cachecontact, false);
            }

            com.soundcode.chat.model.realms.RealmLocation locationObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_soundcode_chat_model_realms_RealmLocationRealmProxy.insert(realm, locationObj, cache);
                }
                table.setLink(columnInfo.locationIndex, rowIndex, cachelocation, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.soundcode.chat.model.realms.QuotedMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.soundcode.chat.model.realms.QuotedMessage.class);
        long tableNativePtr = table.getNativePtr();
        QuotedMessageColumnInfo columnInfo = (QuotedMessageColumnInfo) realm.getSchema().getColumnInfo(com.soundcode.chat.model.realms.QuotedMessage.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$messageId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$messageId();
        if (realmGet$messageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.messageIdIndex, rowIndex, false);
        }
        String realmGet$fromId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromId();
        if (realmGet$fromId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromIdIndex, rowIndex, false);
        }
        String realmGet$fromPhone = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromPhone();
        if (realmGet$fromPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, false);
        }
        String realmGet$toId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$toId();
        if (realmGet$toId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.toIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$content = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$metadata = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$metadata();
        if (realmGet$metadata != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metadataIndex, rowIndex, false);
        }
        String realmGet$mediaDuration = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$mediaDuration();
        if (realmGet$mediaDuration != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, false);
        }
        String realmGet$thumb = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$thumb();
        if (realmGet$thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbIndex, rowIndex, false);
        }
        String realmGet$fileSize = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fileSize();
        if (realmGet$fileSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, false);
        }

        com.soundcode.chat.model.realms.RealmContact contactObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$contact();
        if (contactObj != null) {
            Long cachecontact = cache.get(contactObj);
            if (cachecontact == null) {
                cachecontact = com_soundcode_chat_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, contactObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.contactIndex, rowIndex);
        }

        com.soundcode.chat.model.realms.RealmLocation locationObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_soundcode_chat_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.soundcode.chat.model.realms.QuotedMessage.class);
        long tableNativePtr = table.getNativePtr();
        QuotedMessageColumnInfo columnInfo = (QuotedMessageColumnInfo) realm.getSchema().getColumnInfo(com.soundcode.chat.model.realms.QuotedMessage.class);
        com.soundcode.chat.model.realms.QuotedMessage object = null;
        while (objects.hasNext()) {
            object = (com.soundcode.chat.model.realms.QuotedMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$messageId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$messageId();
            if (realmGet$messageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.messageIdIndex, rowIndex, false);
            }
            String realmGet$fromId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromId();
            if (realmGet$fromId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromIdIndex, rowIndex, false);
            }
            String realmGet$fromPhone = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fromPhone();
            if (realmGet$fromPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, false);
            }
            String realmGet$toId = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$toId();
            if (realmGet$toId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.toIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$content = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
            }
            String realmGet$metadata = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$metadata();
            if (realmGet$metadata != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metadataIndex, rowIndex, false);
            }
            String realmGet$mediaDuration = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$mediaDuration();
            if (realmGet$mediaDuration != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, false);
            }
            String realmGet$thumb = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$thumb();
            if (realmGet$thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbIndex, rowIndex, false);
            }
            String realmGet$fileSize = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$fileSize();
            if (realmGet$fileSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, false);
            }

            com.soundcode.chat.model.realms.RealmContact contactObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$contact();
            if (contactObj != null) {
                Long cachecontact = cache.get(contactObj);
                if (cachecontact == null) {
                    cachecontact = com_soundcode_chat_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, contactObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.contactIndex, rowIndex);
            }

            com.soundcode.chat.model.realms.RealmLocation locationObj = ((com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_soundcode_chat_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, locationObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
            }
        }
    }

    public static com.soundcode.chat.model.realms.QuotedMessage createDetachedCopy(com.soundcode.chat.model.realms.QuotedMessage realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.soundcode.chat.model.realms.QuotedMessage unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.soundcode.chat.model.realms.QuotedMessage();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.soundcode.chat.model.realms.QuotedMessage) cachedObject.object;
            }
            unmanagedObject = (com.soundcode.chat.model.realms.QuotedMessage) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface unmanagedCopy = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) unmanagedObject;
        com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface realmSource = (com_soundcode_chat_model_realms_QuotedMessageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$messageId(realmSource.realmGet$messageId());
        unmanagedCopy.realmSet$fromId(realmSource.realmGet$fromId());
        unmanagedCopy.realmSet$fromPhone(realmSource.realmGet$fromPhone());
        unmanagedCopy.realmSet$toId(realmSource.realmGet$toId());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$content(realmSource.realmGet$content());
        unmanagedCopy.realmSet$metadata(realmSource.realmGet$metadata());
        unmanagedCopy.realmSet$mediaDuration(realmSource.realmGet$mediaDuration());
        unmanagedCopy.realmSet$thumb(realmSource.realmGet$thumb());
        unmanagedCopy.realmSet$fileSize(realmSource.realmGet$fileSize());

        // Deep copy of contact
        unmanagedCopy.realmSet$contact(com_soundcode_chat_model_realms_RealmContactRealmProxy.createDetachedCopy(realmSource.realmGet$contact(), currentDepth + 1, maxDepth, cache));

        // Deep copy of location
        unmanagedCopy.realmSet$location(com_soundcode_chat_model_realms_RealmLocationRealmProxy.createDetachedCopy(realmSource.realmGet$location(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("QuotedMessage = proxy[");
        stringBuilder.append("{messageId:");
        stringBuilder.append(realmGet$messageId() != null ? realmGet$messageId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fromId:");
        stringBuilder.append(realmGet$fromId() != null ? realmGet$fromId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fromPhone:");
        stringBuilder.append(realmGet$fromPhone() != null ? realmGet$fromPhone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{toId:");
        stringBuilder.append(realmGet$toId() != null ? realmGet$toId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content() != null ? realmGet$content() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{metadata:");
        stringBuilder.append(realmGet$metadata() != null ? realmGet$metadata() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mediaDuration:");
        stringBuilder.append(realmGet$mediaDuration() != null ? realmGet$mediaDuration() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumb:");
        stringBuilder.append(realmGet$thumb() != null ? realmGet$thumb() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fileSize:");
        stringBuilder.append(realmGet$fileSize() != null ? realmGet$fileSize() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact:");
        stringBuilder.append(realmGet$contact() != null ? "RealmContact" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{location:");
        stringBuilder.append(realmGet$location() != null ? "RealmLocation" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_soundcode_chat_model_realms_QuotedMessageRealmProxy aQuotedMessage = (com_soundcode_chat_model_realms_QuotedMessageRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aQuotedMessage.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aQuotedMessage.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aQuotedMessage.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
