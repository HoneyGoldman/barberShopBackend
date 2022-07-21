package com.honey.Barber.DAO.Calendar;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.honey.Barber.Beans.Day;


@Transactional
public interface DayRepoJPA extends JpaRepository<Day, Long>{

}
