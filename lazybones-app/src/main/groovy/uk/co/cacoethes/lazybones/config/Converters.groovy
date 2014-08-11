package uk.co.cacoethes.lazybones.config

/**
 * Created by pledbrook on 09/08/2014.
 */
class Converters {
    static final Map<Class, Converter> converterMap = Collections.unmodifiableMap([
            (Boolean): new BooleanConverter(),
            (Integer): new IntegerConverter(),
            (String): new StringConverter(),
            (URI): new UriConverter()])

    static <T> Converter<T> getConverter(Class<T> theClass) {
        if (theClass.isArray()) return new ListConverter(theClass.componentType)

        return converterMap.get(theClass)
    }
}
