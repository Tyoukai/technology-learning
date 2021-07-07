package mapStructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-07-07
 */
@Mapper
public interface ConvertMapper {

    @Named("convertBooleanToInt")
    default int convertBooleanToInt(boolean sex) {
        if (sex) {
            return 1;
        } else {
            return 0;
        }
    }

    ConvertMapper INSTANCE = Mappers.getMapper(ConvertMapper.class);

    @Mapping(source = "subObjectSource", target = "subObjectTarget")
    Target toTarget(Source source);

    @Mapping(source = "sex", target = "sex", qualifiedByName = "convertBooleanToInt")
    SubObjectTarget toTargetSubObject(SubObjectSource subObjectSource);
}
