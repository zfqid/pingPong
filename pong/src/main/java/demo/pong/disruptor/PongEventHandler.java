package demo.pong.disruptor;

import com.lmax.disruptor.EventHandler;
import demo.pong.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.File;

public class PongEventHandler implements EventHandler<MessageModel> {
    private  static Logger logger = LoggerFactory.getLogger(PongEventHandler.class);
    @Override
    public void onEvent(MessageModel event, long sequence, boolean endOfBatch) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String content= new String("");
        if(event==null) return;
        File file = event.getFile();
        if(!file.exists()) return;
        content = FileUtil.getFileContent(file);
        file.delete();
        stopWatch.stop();
        logger.info("file path：{}, file content：{}，processing time：{}millisecond",file.getAbsolutePath(),content,stopWatch.getTotalTimeMillis());
    }
}