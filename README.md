## 1. Contexte général

   L’université souhaite disposer d’un système centralisé permettant à la fois :
   - de planifier efficacement les sessions d’examens semestriels,
   - de gerer l'acces à la salle d'examen et prise de présence par technologie RFID
   - de gérer la saisie, la validation et la publication des résultats,
   - de faciliter l’accès aux relevés pour les étudiants.
   - et permettre aux étudiants d'introduire un recours après avoir vu leurs notes
   
   Le système devra être accessible via une interface web et mobile, sécurisé et interconnecté.


## 2. Objectifs du projet

    - digitaliser le processus de planification des examens
    - centraliser la gestion des notes et des résultats académiques-en systeme LMD
    - automatiser la génération de relevés de cotes après chaque fin de semestre
    - permettre aux étudiants d’accéder à leurs informations en temps réel
    - offrir une vision globale à l’administration (statistiques : de quoi ?, validations, etc.)


## 3. Acteurs du système

   | Acteur                     | Description                                                                                           |
   | -------------------------- | ------------------------------------------------------------------------------------------------------|
   | Administrateur             | Supervise le système, gère les comptes, les paramètres globaux       			                        |
   | Secrétariat facultaire     | Planifie les sessions, gère les matières et promotions            			                        |
   | Professeur                 | Dépose les notes, consulte les statistiques par rapport aux resultats dans sa matière, visualiser les recours des étudiants       |
   | Étudiant                   | Consulte son planning d’examen, ses notes,introduire recours, télécharge ses relevés 	                |
   | Carte et lecteur RFID      | Controle d'accès à la salle d'examen et prise de présence de la participation d'étudiants aux examens |

## 4. Exigences fonctionnelles
   ### 4.1 Planification des examens
   - Créer une session (session normale, rattrapage)
   - Planifier les examens (dates, heures, salles)
   - Associer matières, promotions, surveillants
   - Générer le planning d’examen par promotionReq ou salle
   - Exportation PDF du planning

   ### 4.2 Gestion des notes et résultats
   - Affecter les matières aux enseignants
   - Saisie des notes (par matière / étudiant)
   - Calcul automatique des moyennes, crédits, UE validées
   - Validation et publication des résultats
   - Historique des notes par étudiant
   - Gestion des résultats de session de rattrapage
   - (Penser aussi à la délibération)

   ### 4.3 Relevés et bulletins
   - Génération automatique de bulletins PDF
   - Ajout de signature numérique
   - Génération de QR Code pour vérification en ligne
   - Téléchargement par l’étudiant depuis son espace

   ### 4.4 Portail étudiant
   - Consulter le planning des examens
   - Visualiser ses notes
   - Introduire un récours si bésoin... si besoin de réagir à une note donnée
   - Consulter les crédits validés
   - consulter ses complements, ainsi que les jours où ils sont programmés pour examens
   - Télécharger les bulletins
   - Notifications en cas de nouvelle note ou convocation

   ### 4.5 Notifications
   - Envoi de mails et SMS lors de :
   - Programmation d’un examen
   - Publication des résultats
   - Modification de planning


## 5. Exigences non fonctionnelles
   | Critère            | Détail                                                  |
   | ------------------ | ------------------------------------------------------- |
   | Sécurité           | Authentification JWT, rôles, journalisation des actions |
   | Scalabilité        | Architecture microservices prête pour le cloud          |
   | Accessibilité      | Web responsive (React-Next.JS), mobile Flutter          |
   | Maintenabilité     | Code bien structuré, modulaire, tests unitaires         |
   | Performance        | Temps de réponse rapide, base de données optimisée      |

## 6. Architecture technique proposée
   A. Backend
   Spring Boot, avec microservices :
   - exam-session-service
   - result-service
   - appeal-service
   - user-service
   - document-service
   - notification-service

   B. Spring Security pour gestion d’accès
   
   C. PostgreSQL pour la base de données
   
   D. MinIO pour le stockage des fichiers (bulletins PDF)
   
   E. Kafka pour les événements (notifications, mises à jour)
   
   F. Frontend
   - Next.js
   - Flutter pour l’application mobile
   
   G. Autres
   
   - Eureka pour la découverte de services
   - Spring Cloud Gateway comme passerelle API
   - Docker pour le déploiement

## 7. Cas d’usage simplifié

    1. L’admin crée une session d’examen (Janvier 2026)
    2. Le secrétariat y planifie les examens par matière et promotionReq
    3. Le professeur saisit ses notes en ligne
    4. Le secrétariat visualise les résultats et génère les bulletins
    5. L’étudiant est notifié, se connecte pour visualiser ses résultats, et peut maintenant introduire un récours ou télécharger son relevé semestriel
    6. En cas de rattrapage, un second planning est lancé

## 8. Livrables attendus

    - Code source complet (frontend + backend)
    - Base de données PostgreSQL (structure et données de test)
    - Documentation technique (Swagger pour l’API, readme, diagrammes)
    - Manuel utilisateur
    - Cahier de tests (fonctionnels et unitaires)
    - Application mobile Flutter (APK)
