package GAJI;

import GAJI.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NotilistViewHandler {


    @Autowired
    private NotilistRepository notilistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSent_then_CREATE_1 (@Payload Sent sent) {
        try {
            if (sent.isMe()) {
                // view 객체 생성
                Notilist notilist = new Notilist();
                // view 객체에 이벤트의 Value 를 set 함
                notilist.setMemverId(sent.getMemberId());
                notilist.setMsg(sent.getMsg());
                // view 레파지 토리에 save
                notilistRepository.save(notilist);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @StreamListener(KafkaProcessor.INPUT)
    @Transactional
    public void whenLeft_then_DELETE_1(@Payload Left left) {
        try {
            if (left.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                System.out.println("Deleted..................");
                System.out.println(left.getId());

                notilistRepository.deleteByMemverId(left.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}