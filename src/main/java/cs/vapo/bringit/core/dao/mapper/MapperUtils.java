package cs.vapo.bringit.core.dao.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapperUtils {

    private MapperUtils() {

    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        final ModelMapper modelMapper = new ModelMapper();
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * Maps all non-null source properties that match with the target properties
     * @param source the source object
     * @param target the target object to which the properties are copied
     * @param ignorable a {@link Set} of ignorable source properties that should not be copied unto the target object
     */
    public static void mapNonNull(final Object source, final Object target, Set<String> ignorable) {
        final String CLASS_DESCRIPTOR = "class";
        final BeanWrapper sourceWrapper = new BeanWrapperImpl(source);
        final BeanWrapper targetWrapper = new BeanWrapperImpl(target);
        if (ignorable == null) {
            ignorable = new HashSet<>();
        }

        for (final PropertyDescriptor descriptor : sourceWrapper.getPropertyDescriptors()) {
            final String descriptorName = descriptor.getName();
            if (descriptorName.equals(CLASS_DESCRIPTOR) || ignorable.contains(descriptorName)) {
                continue;
            }

            final Object value = sourceWrapper.getPropertyValue(descriptorName);
            if (value != null) {
                try {
                    targetWrapper.setPropertyValue(descriptorName, value);
                } catch (Exception exp) {
                    // we want to ignore any exception while copying values
                }

            }
        }
    }
}
