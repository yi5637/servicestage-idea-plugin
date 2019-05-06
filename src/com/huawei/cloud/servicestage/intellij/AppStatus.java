package com.huawei.cloud.servicestage.intellij;

public class AppStatus {

    public static String UNKNOWN = "UNKNOWN";

    public static String INITIALIZING = "INITIALIZING";

    public static String UPGRADING = "UPGRADING";

    public static String FAILED = "FAILED";

    public static String DELETING = "DELETING";

    public static String SUCCEEDED = "SUCCEEDED";

    public static String RUNNING = "RUNNING";

    private final String status;

    private final String details;

    public AppStatus(String status, String details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDetails() {
        return this.details;
    }

}
