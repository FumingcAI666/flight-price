package com.haina.flight.price.service.impl;

import com.haina.flight.price.comstants.constants;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class ZkWatchServiceImpl implements Watcher {
    @Resource
    private ZooKeeper zooKeeper;

    /*
    @PostConstruct
    public void init(WatchedEvent watchedEvent){
        try {
            zooKeeper.exists("/abc",true);
            zooKeeper.exists("/def",true);
            Stat stat = new Stat();
            byte[] data = new byte[0];

            data = zooKeeper.getData("/abc",true ,stat);
            String str = new String(data);

            if(watchedEvent.getPath().equals("abc")){
                constants.abc = Integer.valueOf(str);
            }else if(watchedEvent.getPath().equals("def")){
                constants.abc = Integer.valueOf(str);
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    */
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()){
                System.out.println("连接上了服务器");
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                //字节点发生变化的状态
                System.out.println("节点发生了变化");
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged){
                System.out.println("节点的值发生了变化");
                System.out.println("改变的path是:" + watchedEvent.getPath());

                Stat stat = new Stat();
                byte[] data = new byte[0];
                try {
                    data = zooKeeper.getData(watchedEvent.getPath(),true ,stat);
                    String str = new String(data);

                    if(watchedEvent.getPath().equals("abc")){
                        constants.abc = Integer.valueOf(str);
                    }else if(watchedEvent.getPath().equals("def")){
                        constants.abc = Integer.valueOf(str);
                    }

                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
