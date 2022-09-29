/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Sep 15, 2022
 */
package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListMusicStudent;

public class ListMusicStudentHelper {
		static EntityManagerFactory emfactory =
		Persistence.createEntityManagerFactory("MusicStudent");
		
		public void insertStudent(ListMusicStudent li) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();
		}
		public List<ListMusicStudent> showAllStudents(){
			EntityManager em = emfactory.createEntityManager();
			List<ListMusicStudent> allStudents = em.createQuery("SELECT i from ListMusicStudent i").getResultList();
			return allStudents;
			}
		public void deleteStudent(ListMusicStudent toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ListMusicStudent>typedQuery = em.createQuery("select li from ListMusicStudent li where li.instrument = :selectedInstrument and li.name = :selectedName", ListMusicStudent.class);
			typedQuery.setParameter("selectedName", toDelete.getName());
			typedQuery.setParameter("selectedInstrument", toDelete.getInstrument());
			typedQuery.setMaxResults(1);
			ListMusicStudent result = typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			}
		
		public List<ListMusicStudent> searchForStudentByName(String studentName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ListMusicStudent> typedQuery = em.createQuery("select li from ListMusicStudent li where li.name = :selectedStudent", ListMusicStudent.class);
			typedQuery.setParameter("selectedStudent", studentName);
			List<ListMusicStudent> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public List<ListMusicStudent> searchForStudentByInstrument(String instrumentType) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<ListMusicStudent> typedQuery = em.createQuery("select li from ListMusicStudent li where li.instrument = :selectedInstrument", ListMusicStudent.class);
			typedQuery.setParameter("selectedInstrument", instrumentType);
			List<ListMusicStudent> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public ListMusicStudent searchForStudentById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			ListMusicStudent found = em.find(ListMusicStudent.class, idToEdit);
			em.close();
			return found;
		}
		
		public void updateStudent(ListMusicStudent toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();		
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			
		}
		public void cleanUp(){
			emfactory.close();
			}
	}

