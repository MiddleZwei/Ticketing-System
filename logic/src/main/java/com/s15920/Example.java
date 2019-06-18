//package com.s15920;
//
//import org.hibernate.Session;
//
//import java.util.List;
//
//
///**
// * Class used to perform CRUD operation on database with Hibernate API's
// *
// */
//public class Example {
//
//    @SuppressWarnings("unused")
//    public static void main(String[] args) {
//
//        Example application = new Example();
//
//        /*
//         * Save few objects with hibernate
//         */
//
//        int address = application.saveAddress("ala1","aal2", "city", "dist", "00000", "00000");
////        int  address = application.getAddressId("al1");
//        System.out.println(address);
//        int personId1 = application.savePerson("Bissssasdsassdlsslaasd31", "Laurent1sa6", "email13", "phon3e1", address);
////        int personId2 = application.savePerson("Bill4", "Laurent5", "email24", "phon6e2", 2);
//
//        /*
//         * Retrieve all saved objects
//         */
//        List<Person> persons = application.getAllPersons();
//        System.out.println("List of all persisted persons >>>");
//        for (Person person : persons) {
//            System.out.println("Persisted Person :" + person);
//        }
//
//        /*
//         * Update an object
//         */
////        application.updatePerson(2, "new email");
//
//        /*
//         * Deletes an object
//         */
////        application.deletePerson(1);
//
//        /*
//         * Retrieve all saved objects
//         */
//        List<Person> remainingPersons = application.getAllPersons();
//        System.out.println("List of all remained persisted persons >>>");
//        for (Person person : remainingPersons) {
//            System.out.println("Persisted Person :" + person);
//        }
//
//    }
//
//    private int getAddressId(String al1) {
//        DataBroker db = new DataBroker();
//        Address a = db.getAddressByAddressLine(al1);
//        System.out.println(getAddressId(al1));
//        return a.getAddressId();
//    }
//
//    private int saveAddress(String al1, String al2, String city, String dist, String zip, String s1) {
//        DataBroker db = new DataBroker();
//
//        Address address = new Address();
//        address.setAddressLine1(al1);
//        address.setAddressLine2(al2);
//        address.setCity(city);
//        address.setDistrict(dist);
//        address.setPostalCode(zip);
//        address.setPhone(s1);
//
//        return db.saveOrUpdate(address);
//    }
//
//    /**
//     * This method saves a Student object in database
//     */
//    public int savePerson(String firstName, String lastName, String email, String phone, int fk_address) {
//        DataBroker db = new DataBroker();
//        Person p = new Person();
//        p.setFirstName(firstName);
//        p.setLastName(lastName);
//        p.setEmail(email);
//        p.setMobile(phone);
//        return db.saveOrUpdate(p, fk_address);
//    }
//
//    /**
//     * This method returns list of all persisted Student objects/tuples from
//     * database
//     */
//    public List<Person> getAllPersons() {
//        DataBroker db = new DataBroker();
//        return db.getAllPersons();
//    }
//
//    /**
//     * This method updates a specific Student object
//     */
//    public void updatePerson(int id, String email) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Person person = (Person) session.get(Person.class, id);
//        person.setEmail(email);
//        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    /**
//     * This method deletes a specific Student object
//     */
//    public void deletePerson(int id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Person person = (Person) session.get(Person.class, id);
////        System.out.println(session);
//        session.delete(person);
//        session.getTransaction().commit();
//        session.close();
//    }
//}