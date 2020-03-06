package org.example;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper newOne;
        String connectString = "192.168.95.137:2181,192.168.95.138:2181,192.168.95.139:2181";
        int sessionTimeout = 2000;
        newOne = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        });

        System.out.println(newOne.getState());
        String path = newOne.create("/father/childrenOne", "lijinghua".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }
}