package br.com.viasoft.demo_mysql.routing;

public class ReadOnlyContextHolder {

    private static final ThreadLocal<Boolean> contextHolder = new ThreadLocal<>();

    public static void setReadOnly(boolean readOnly) {
        contextHolder.set(readOnly);
    }

    public static boolean isReadOnly() {
        Boolean readOnly = contextHolder.get();
        return readOnly != null && readOnly;
    }

    public static void clear() {
        contextHolder.remove();
    }
}
