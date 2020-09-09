package GAJI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotilistRepository extends CrudRepository<Notilist, Long> {


        void deleteByMemverId(Long memverId);
}