package com.sample.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.dao.UserDao;
import com.sample.model.User;

@Repository("userDam")
public class UserDaoImpl implements UserDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    protected Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

	public Integer addUser(User localUsr) {
		return (Integer) this.getCurrentSession().save(localUsr);
	}

	public List<User> getAllUsers() {
		return this.getCurrentSession().createQuery("From User").list();
	}

	public User getUser(int userId) {
		return (User) this.getCurrentSession().get(User.class, new Integer(userId));
	}

	@Override
	public Integer updateUser(User usr) {
		return (Integer)this.getCurrentSession().save(usr);
	}

	@Override
	public void deleteUser(User usr) {
		this.getCurrentSession().delete(usr);
	}
	
}
