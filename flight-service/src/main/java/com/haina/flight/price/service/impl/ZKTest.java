package com.haina.flight.price.service.impl;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZKTest implements Watcher {
    public static void main(String[] args) throws IOException {
        ZKTest zkTest = new ZKTest();
        try {
            ZooKeeper zooKeeper = new ZooKeeper("10.0.100.204:2181", 3000, zkTest);

            String path1 = zooKeeper.create("/path1", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //System.out.println(path1);

            // 节点存在stat对象
            Stat stat = new Stat();
            byte[] data = zooKeeper.getData("/path1", true, stat);

            // zooKeeper.setData("/path1","/path2".getBytes(),stat.getVersion());
            // System.out.println(new String(data));

            data = zooKeeper.getData("/path1", true, stat);
            System.out.println(new String(data));

            zooKeeper.delete("/path1", stat.getVersion());

            System.out.println(new String(data));

            System.out.println(stat);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) { // 监听器
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                System.out.println("连接上了服务器");
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                //字节点发生变化的状态
                System.out.println("节点发生了变化");
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                System.out.println("节点的值发生了变化");
                System.out.println("改变的path是:" + watchedEvent.getPath());
            }
        }

    }
}
