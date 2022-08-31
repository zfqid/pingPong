package demo.pong.service;

import java.io.File;

public interface DisruptorPongService {

    /**
     * message
     * @param file
     */
    void processPongMsg(File file);

     void processPongJob(String filePath);
}
