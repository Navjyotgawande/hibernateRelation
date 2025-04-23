package org.example;

import org.example.Entity.Answer;
import org.example.Entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneMap {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session =sessionFactory.openSession();
            Transaction t =session.beginTransaction();
            Question question = new Question();
            question.setQuestionId(107);
              question.setQuestion("What is java");
            //create answer object
            Answer answer = new Answer();
          answer.setAnswerId(107);
            answer.setAnswer("Java is an Object oriented programming language");
//            answer.setQuestion(question);

          question.setAnswer(answer);
            session.save(answer);
           session.save(question);

          t.commit();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
