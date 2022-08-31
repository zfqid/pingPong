package demo.ping.service.impl;

import demo.ping.service.PingService;
import demo.ping.util.FileUtil;
import demo.ping.vo.FileVo;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class PingServiceImpl implements PingService {
    @Override
    public FileVo writeFile(String filePath) {
        long timeStamp = System.currentTimeMillis();
        String fileName = timeStamp+".txt";
        FileVo fileVo = new FileVo();
        fileVo.setFilePath(filePath);
        fileVo.setFileName(fileName);
        try {
            fileVo.setCreated(FileUtil.ceateFileByContent(fileVo,"hello")+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileVo;
    }

}
