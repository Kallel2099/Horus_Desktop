/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knowledge.horus.controls;

/**
 *
 * @author Kallel
 */
public class HorusDao {
    
}
/*
01 package br.com.devmedia.java.hibernate;
02
03 import javax.persistence.EntityManagerFactory;
04 import javax.persistence.Persistence;
05
06 public class Main {
07
08     private static EntityManagerFactory entityManagerFactory;
09
10     public static void main(String args[]) {
11
12         entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
13     }
14 }

01 public static void main(String args[]) {
02   entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
03   Lembrete lembrete = new Lembrete();
04   lembrete.setTitulo("Comprar leite");
05   lembrete.setDescricao("Hoje, 10h30");
06   EntityManager em = entityManagerFactory.createEntityManager();
07
08   try {
09      em.getTransaction().begin();
10      em.persist(lembrete);
11      em.getTransaction().commit();
12   } catch (Exception e) {
13      em.getTransaction().rollback();
14
15      System.out.println("INSERT: " + e.getMessage());
16   } finally {
17      em.close();
18   }
19 }

01 public static void main(String args[]) {
02   entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
03
04   List<Lembrete> lembretes = null;
05
06   EntityManager em = entityManagerFactory.createEntityManager();
07
08   try {
09    lembretes = em.createQuery("from Lembrete").getResultList();
10   } catch (Exception e) {
11    System.out.println("LIST ALL: " + e.getMessage());
12   } finally {
13    em.close();
14   }
15
16   if (lembretes != null) {
17    lembretes.forEach(System.out::println);
18   }
19 }

01 public class Main {
02
03   private static EntityManagerFactory entityManagerFactory;
04
05   public static void main(String args[]) {
06
07    entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
08
09     EntityManager em = entityManagerFactory.createEntityManager();
10
11     try {
12    lembrete = em.find(Lembrete.class, 1L);
13     } finally {
14       em.close();
15     }
16
17     System.out.println(lembrete);
18   }
19 }

01 public class Main {
02
03   private static EntityManagerFactory entityManagerFactory;
04
05   public static void main(String args[]) {
06
07     entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
08
09     List<Lembrete> lembretes = null;
10
11     EntityManager em = entityManagerFactory.createEntityManager();
12
13     try {
14       lembretes = em.createQuery("from Lembrete l where l.titulo LIKE '%comprar%'").getResultList();
15     } catch (Exception e) {
16       System.out.println("LIST ALL: " + e.getMessage());
17     } finally {
18       em.close();
19     }
20
21     if (lembretes != null) {
22       lembretes.forEach(System.out::println);
23     }
24   }
25 }

01 public class Main {
02   private static EntityManagerFactory entityManagerFactory;
03
04   public static void main(String args[]) {
05     entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
06
07     EntityManager em = entityManagerFactory.createEntityManager();
08
09     try {
10       lembrete = em.find(Lembrete.class, 1L);
11
12       lembrete.setTitulo("Comprar café");
13       lembrete.setDescricao("Hoje, 8h22");
14
15       em.getTransaction().begin();
16       em.merge(lembrete);
17       em.getTransaction().commit();
18     } catch (Exception e) {
19       em.getTransaction().rollback();
20
21       System.out.println("UPDATE: " + e.getMessage());
22     } finally {
23      em.close();
24    }
25   }
26 }

01 package br.com.devmedia.java.primeiraapphibernatejpa;
02
03 import javax.persistence.EntityManager;
04 import javax.persistence.EntityManagerFactory;
05 import javax.persistence.Persistence;
06 import java.util.List;
07
08 public class Main {
09
10     private static EntityManagerFactory entityManagerFactory;
11
12     public static void main(String args[]) {
13
14         entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
15
16         EntityManager em = entityManagerFactory.createEntityManager();
17
18         try {
19            em.getTransaction().begin();
20            lembrete = em.find(Lembrete.class, 1l);
21            em.remove(lembrete);
22            em.getTransaction().commit();
23         } catch (Exception e) {
24            em.getTransaction().rollback();
25
26            System.out.println("DELETE: " + e.getMessage());
27         } finally {
28            em.close();
29         }
30     }
31 }
*/