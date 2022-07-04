package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Member member = new Member();
            member.setName("member");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddresses().add(new Address("old1", "street", "10000"));
            member.getAddresses().add(new Address("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=======START ==========");
            Member findMember = em.find(Member.class, member.getId());
            List<Address> addressHistory = findMember.getAddresses();
            for (Address address : addressHistory) {
                System.out.println("address : " + address.getCity());
            }
            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }
//            Address address = new Address("city", "street", "10000");
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
//
//            member.setHomeAddress(newAddress);
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity");

        } catch (Exception e) {

        }finally {
            tx.commit();
            em.close();
        }
    }
}
