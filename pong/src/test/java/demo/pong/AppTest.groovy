package demo.pong

import demo.pong.service.DisruptorPongService
import demo.pong.util.FileUtil
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification;

@ContextConfiguration(classes = DisruptorPongService.class)
@SpringBootTest(classes = App.class)
class AppTest extends Specification {

    @Autowired
    private DisruptorPongService disruptorPongService;
    def "disruptor test"() {
        given:
        def  filePath = "E:\\pong\\file";
        def  fileName = "1661577283010.txt";
        def  content = "testHello";
        def  file = new File(filePath);
        file.mkdirs();
        file = new File(filePath+File.separator+fileName);
        file.createNewFile()
        FileOutputStream local = new FileOutputStream(file)
        local.write(content.getBytes());
        when:
            disruptorPongService.processPongMsg(file);
        then:
            true
    }
    def "processPongJob test"() {
        given:
        def  filePath = "/pong/";
        def  fileName = "testPongJob.txt";
        def  content = "hello"
        def  file = new File(filePath);
        file.mkdirs();
        file = new File(filePath+fileName);
        file.createNewFile()
        FileOutputStream local = new FileOutputStream(file)
        local.write(content.getBytes());
        when:
        disruptorPongService.processPongJob(filePath)
        then:
        true
    }
    def "get file content test"() {
        given:
        def  filePath = "/pong/";
        def  fileName = "testPongContent.txt";
        def  content = "hello"
        def  file = new File(filePath);
        file.mkdirs();
        file = new File(filePath+fileName);
        file.createNewFile()
        FileOutputStream local = new FileOutputStream(file)
        local.write(content.getBytes());
        when:
        def result = FileUtil.getFileContent(file)
        then:
        result.equals(content)
    }

}
