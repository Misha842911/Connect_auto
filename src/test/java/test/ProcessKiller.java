package test.java.test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Set;
import java.util.stream.Stream;

//public class ProcessKiller {
//    public static void KillByName(String processName, int timeOut){
//        StopWatch sw = new StopWatch();
//        sw.start();
//
//        Stream<ProcessHandle> handles = ProcessHandle.allProcesses();
//        String proc = ProcessHandle.of().get().
//
//            while (ProcessHandle.current().isAlive(). && sw.getTime() < timeOut*1000){
//            while (ProcessHandle.Info.class.getName().contains(processName) && sw.getTime() < timeOut*1000){
//                for (var process : ProcessHandle.allProcesses().equals(processName)) {
//
//                }
//            }
//
//
//
//            while (Process.GetProcessByName()  getName().contains(processName) )
//    }
//}

public class ProcessKiller {
    public static void KillByName(String processName, int timeOut){
        StopWatch sw = new StopWatch();
        sw.start();

        while (Process.GetProcessesByName(processName).Length > 0 && sw.ElapsedMilliseconds < timeOut * 1000){
            while (ProcessHandle.Info.class.getName().contains(processName) && sw.getTime() < timeOut*1000){
                for (var process : ProcessHandle.allProcesses().equals(processName)) {

                }
            }



            while (Process.GetProcessByName()  getName().contains(processName) )
        }
    }
