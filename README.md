<h1>Contexte :</h1>
<p>
  Ce projet s’inscrit dans le cadre du coding test proposé par Softway Medical. Il s'agit de traiter et d'afficher les résultats d’un index de santé transmis par une cabine d’auto-diagnostic, afin d’aiguiller le patient vers la ou les unités médicales concernées.
</p>

<h1>Choix techniques :</h1>
<ul>
  <li><h2>Java 17 : </h2><p>J’ai utilisé Java 17 afin d’être en cohérence avec l’environnement technologique actuel de Softway Medical.</p></li>
   <li><h2>Internationalisation (FR/EN) : </h2><p>Un système de gestion multilingue a été mis en place (français/anglais), en réponse à une remarque faite lors de l’entretien sur la présence de projets à destination de l’international.</p></li>
  <li><h2>Séparation logique : </h2><p>L’algorithme de traitement est séparé de la génération de la chaîne de caractères à afficher, afin de faciliter la maintenance, notamment si le format d'affichage venait à évoluer.</p></li>
  <li><h2>Type MedicalUnit dédié : </h2><p>J’ai introduit un type spécifique pour représenter les unités médicales. Cela permet d’anticiper de futurs besoins, comme l’affichage d’informations supplémentaires (lieu, médecin, etc.).</p></li>
  <li><h2>Hypothèse de sécurité : </h2><p>J’ai considéré que les données reçues étaient cryptées et déjà décryptées en amont. Ce choix reflète l'importance de la sécurité dans un contexte hospitalier, souvent ciblé par des cyberattaques.</p></li>
  <li><h2>Commentaires en anglais : </h2><p>Tout le code est commenté en anglais afin d’assurer sa maintenabilité, même dans un contexte de maintenance potentiellement délocalisée.</p></li>
  <li><h2>Application backend complète : </h2><p>Plutôt que de me limiter à une simple méthode Java, j’ai choisi d’implémenter un backend complet, testé via Postman. Cela me permet de me rapprocher des conditions réelles d’un projet en production.</p></li>  
</ul>
