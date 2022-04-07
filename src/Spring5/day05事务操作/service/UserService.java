package Spring5.day05事务操作.service;

import Spring5.day05事务操作.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = 1, rollbackFor = Exception.class)
public class UserService {

    // 注入dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void accountMoney(){
        userDao.reduceMoney();
        int i = 10 / 0;
        userDao.addMoney();
    }
}
