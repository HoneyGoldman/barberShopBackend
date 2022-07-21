package com.honey.Barber.DAO.Calendar;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.honey.Barber.Beans.Month;

@Transactional
public interface MonthRepoJPA extends JpaRepository<Month, Long>{

}
