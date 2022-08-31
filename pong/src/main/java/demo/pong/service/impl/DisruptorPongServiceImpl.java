package demo.pong.service.impl;

import com.lmax.disruptor.RingBuffer;
import demo.pong.disruptor.MessageModel;
import demo.pong.service.DisruptorPongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DisruptorPongServiceImpl implements DisruptorPongService {
    @Autowired
    private RingBuffer<MessageModel> messageModelRingBuffer;

    @Override
    public void processPongMsg(File file) {
        long sequence = messageModelRingBuffer.next();
        try {
            MessageModel event = messageModelRingBuffer.get(sequence);
            event.setFile(file);
        } catch (Exception e) {
        } finally {
            messageModelRingBuffer.publish(sequence);
        }
    }
    @Override
    public void processPongJob(String filePath) {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        for(File file:files){
            this.processPongMsg(file);
        }
    }
}