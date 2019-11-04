package hw3.otus;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Параметры запуска
-Xms256m
-Xmx256m
-XX:+HeapDumpOnOutOfMemoryError
-XX:+UseG1GC

-XX:+UseSerialGC
-XX:+UseParallelGC
-XX:+UseConcMarkSweepGC


 */

public class GcTest {

    static HashMap<String, Integer> gcInfo_duration = new HashMap<>();
    static HashMap<String, Integer> gcInfo_count = new HashMap<>();


    public static void main(String... args) throws Exception {

        switchOnMonitoring();
        long beginTime = System.currentTimeMillis();
        int size = 5_000_000;
        int loopCounter = 100;
        List<List<String>> tst1 = new ArrayList<>();

        for (int j = 1; j <= loopCounter; j++) {

            List<String> tst = new ArrayList<>();
            System.out.println("Количество сборок - " + gcInfo_count.toString());
            System.out.println("Время выполнения - " + gcInfo_duration.toString());
            System.out.println("time:" + (System.currentTimeMillis() - beginTime) / 1000);
            for (int i = 0; i < size; i++) {
                tst.add(new String("n"+i));
                System.out.println("Количество сборок - " + gcInfo_count.toString());
                System.out.println("Время выполнения - " + gcInfo_duration.toString());
                System.out.println("time:" + (System.currentTimeMillis() - beginTime) / 1000);
                System.out.println("loopCounter - " + j);
                System.out.println("Index of elemets - " + i);
                int size_for_del = tst.size() / 2;
               // System.out.println(i +"-"+i % 10_000);
                /*if (i % 10_000 == 0) {
                    for (int t=0; t < size_for_del; t++) {
                        tst.remove(t);
                    }
                }*/
            }
            System.out.println(j);
            tst1.add(tst);

            Thread.sleep(10);
        }

        //System.out.println("Количество сборок - "+ gcInfo_count.toString());
        //System.out.println("Время выполнения - "+ gcInfo_duration.toString());

        System.out.println("time:" + (System.currentTimeMillis() - beginTime) / 1000);
    }


    public static void switchOnMonitoring() {
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean gcbean : gcbeans) {
            System.out.println("GC name:" + gcbean.getName());
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
                    String gcName = info.getGcName();
                    String gcAction = info.getGcAction();
                    String gcCause = info.getGcCause();

                    long startTime = info.getGcInfo().getStartTime();
                    long duration = info.getGcInfo().getDuration();

                    //System.out.println("start:" + startTime + " Name:" + gcName + ", action:" + gcAction + ", gcCause:" + gcCause + "(" + duration + " ms)");
                    //System.out.println(gcAction + ";" + duration );

                    gcInfo_duration.put(gcAction, gcInfo_duration.getOrDefault(gcAction, 0) + (int) duration);
                    gcInfo_count.put(gcAction, gcInfo_count.getOrDefault(gcAction, 0) + 1);
                }
            };
            emitter.addNotificationListener(listener, null, null);

        }
    }

}
