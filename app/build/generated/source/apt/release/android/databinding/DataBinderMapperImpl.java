package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.soundcode.chat.DataBinderMapperImpl());
    addMapper(new V1CompatDataBinderMapperImpl());
  }
}
