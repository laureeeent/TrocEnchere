<%@page import="fr.eni.javaee.bo.ArticleVendu"%>
<%@page import="fr.eni.javaee.bll.UtilisateurManager"%>
<%@page import="fr.eni.javaee.bo.Utilisateur"%>
<%@page import="fr.eni.javaee.bo.Enchere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.javaee.bo.Categorie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="JS/index.js"></script>
<title>TrocEnchère</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
	//Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	%>
	<header id="h_principal">
		<%@include file="fragment/div_id_entete.jsp"%>
		<div id="titre_page">
			<h2>CONDITIONS GÉNÉRALES DES VENTES MOBILIÈRES</h2>
		</div>
	</header>
	<main id="m_principal">
	<p>PRÉAMBULE
Les ventes mobilières du Domaine concernent les biens mobiliers dont les organismes publics n’ont plus l’usage, les biens confisqués par la Justice, les véhicules réputés abandonnés dans les fourrières, les objets trouvés, ou les biens abandonnés par les patients des hôpitaux.

Ces ventes sont assurées sur le territoire métropolitain, hors Corse, par la Direction nationale d’interventions domaniales (DNID) rattachée à la Direction de l’immobilier de l’État dépendant de la Direction générale des Finances publiques (DGFIP). Les ventes sont organisées par un réseau de 14 commissariats aux ventes (CAV) répartis sur l’ensemble du territoire métropolitain ou par les services de direction de la DNID.

Dans les départements et collectivités d’outre-mer et en Corse, les services locaux des directions territoriales des Finances publiques assurent cette mission.

Le fonctionnaire responsable de la vente est dénommé « commissaire aux ventes », le propriétaire du bien vendu est dénommé « service remettant », l’expression « comptable public » désigne le Service comptable Spécialisé du Domaine (CSDom) ou le régisseur du CAV chargé de l’encaissement du prix et de ses accessoires. Le « soumissionnaire » désigne la personne physique ou morale qui présente une offre écrite en vue de concourir aux fins de conclusion d'une vente publique par appel d'offre ou marché d'enlèvement.

Les ventes domaniales sont soumises au droit français et sont effectuées selon les formes et conditions du Cahier des Clauses Administratives Générales (CCAG). Le CCAG régit les relations entre le Domaine et les services remettants et fixe le cadre juridique des ventes mobilières réalisées par le Domaine.

Les présentes Conditions Générales de Vente (CGV) complètent le CCAG et décrit les modalités pratiques d'organisation et de déroulement des ventes.

Le CCAG et les CGV sont disponibles sur le site internet des ventes du Domaine ( encheres-domaine.gouv.fr ) ou dans les bureaux du CAV mentionné dans l'annonce de la vente, ainsi qu’ au siège de la DNID, les Ellipses, 3 avenue du chemin de Presles, 94417 Saint-Maurice Cedex.

En outre, les ventes domaniales peuvent être soumises à des Conditions Particulières de Vente (CPV) précisées pour chaque vente, qui peuvent déroger en tout ou partie aux dispositions des conditions générales de ventes à l’exception des règles auxquelles serait attaché un caractère d’ordre public. Dans les ventes sur support écrit (marchés d’enlèvement / appels d’offres) les CPV sont précisées dans un Cahier des Clauses Particulières (CCP)

OBJET DE LA VENTE
Les descriptions des biens objets de la vente sont données à titre indicatif et ne sont pas contractuelles.

Elles appellent donc à être vérifiées par l'acquéreur (cf article 6.2)

Les photographies présentes sur le site sont employées à titre d’information et sont non-contractuelles,

Le Domaine ne peut pas vendre certains biens.

La liste ci-dessous n'est pas exhaustive et est susceptible d'évoluer.

2.1 La liste des biens dont la vente est illicite ou exclusive de la compétence domaniale

– Armes, munitions ou éléments de munitions des catégories A rubrique 1 et rubrique 2, alinéas 1 à 5 et 7 et de catégories B à D (arrêté interministériel du 31 juillet 2001(modifié) relatif à la destination des matériels de guerre armes et munitions détenus par l'Etat;

– Prélèvements sanguins et génétiques (articles 16-1 et 16-5 du Code Civil/Avis du Comité National d'Ethique n°77 du 20 mars 2003) ;

– Papiers d’identité (décret 55-1397 relatif à la carte d'identité/ articles 441-1 et suivants du Code Pénal) ;

– Les faux documents : (articles 441-1 et suivants du Code pénal)

– Biens amiantés ou pollués (décret n°96-1133 du 24 décembre 1996) ;

– Pièces et billet ayant cours légal ;

– Contrefaçons : (article L3211-19 CG3P)

– Stupéfiants et le matériel ayant servi à fabriquer ces substances : AJOUT (article 222-37 du Code Pénal

– Machines à sous et jeux de hasard : AJOUT (articles L324-1 et suivants du Code de la Sécurité Intérieure)

– Ivoire brut ou sous forme d’éléments travaillés ;

– Ainsi que, plus généralement, de tout bien dont la cession est interdite en application d’une disposition légale ou réglementaire spéciale qui doit être mentionnée pour justifier la décision de rejet de remise.

 

2.2 La vente contraire à l'éthique ou à la déontologie

Sauf intérêt particulier, toute arme d'une classification autre que celle mentionnée aux premier et second alinéas de l'article 2.1 ci-dessus

– Le tabac ;

– Les cassettes vidéos, DVD, CD, CDROM même neufs et emballés, dans la mesure où il n'est jamais permis de garantir leur contenu réel ;

– Dans certains cas, les biens liés aux chefs de poursuite, c'est-à_dire les objets, sans distinction, ayant servi à commettre une infraction (ex : les passe-partout, fausses plaques minéralogiques).

2.3 La vente impossible pour des raisons liées à la sécurité des personnes

–  Biens en relation avec la sécurité des personnes ou soumis au respect de normes de sécurité particulières dont l’homologation n’est pas rapportée :

– Casques de motos ou de vélo usagés qui ne sont pas sous emballage ;

– Matériel d'alpinisme et les harnais de toutes sortes

– Jouets non conformes aux normes européennes ;

– Cosmétiques et autres produits de beauté , les produits de parapharmacie sur lesquels ne figure pas une date limite d'utilisation et/ou non emballés sous blister ;

– Les denrées alimentaires périssables sauf les vins ou alcools.

LES PROCÉDURES DE VENTE
3.1 Les ventes par adjudication publique

3.1.1/ Les ventes aux enchères verbales

Le commissaire aux ventes dirige la vente de façon discrétionnaire en respectant les usages établis. Il se réserve le droit d’organiser les enchères de la façon la plus appropriée, de déplacer certains lots lors de la vente, de retirer tout lot de la vente, de réunir ou de séparer des lots. Il a de plus la faculté de refuser toute enchère, d’annuler la vente ou de remettre en vente tout lot en cas de contestation.

Les offres de vente sont portées par voie orale ou par signes. La progression du pas d’enchères est fixée par le commissaire aux ventes.

Les prix doivent être exprimés globalement pour chaque lot à moins de dispositions contraires insérées dans les CPV.

Les lots sont adjugés au profit de l’enchérisseur le plus offrant. La vente est conduite en euros et les enchères qui sont formées sont annoncées par le commissaire aux ventes hors frais et hors taxe.

Les enchérisseurs sont réputés ne pas ignorer les frais, ni les taxes applicables aux adjudications. Ils sont mentionnés dans les CGV et CPV, et annoncés par le commissaire aux ventes au début de la vente.

A l’issue de la vente et après paiement total du prix de vente, le comptable public remet à l'adjudicataire une facture, une situation de paiement, une autorisation d'enlèvement et, le cas échéant, une facture tenant lieu de certificat de vente du véhicule.

 

3.1.2/ Les ventes aux enchères verbales diffusées en direct sur Internet

Tout intéressé peut suivre la vente et porter des enchères par voie électronique contre la salle des ventes.

Ce système nécessite une connexion aux plateformes d'enchères en ligne DROUOT Live (www.drouotonline.com) ou MONITEUR Live (www.moniteurlive.com) en respectant la procédure préalable d’inscription et d’authentification ainsi que l’ensemble des conditions générales d’utilisation.

Les enchères électroniques étant assurées par une plate-forme dont la maintenance est confiée à un prestataire extérieur, le Domaine décline toute responsabilité en cas de dysfonctionnement du service ou de difficulté de connexion.

Les réseaux sur lesquels circulent les données présentant des caractéristiques et capacités diverses sont susceptibles d’être saturés à certaines heures de la journée, ce qui est de nature à affecter leur délai de téléchargement ainsi que leur accessibilité. Le Domaine met tout en œuvre pour permettre et maintenir la connexion internet pendant la vente. Toutefois, l’outil de retransmission vidéo et audio de la vente n’étant pas un élément constitutif de la Vente Live, il n'est pas couvert par une garantie de service particulière. En cas d'interruption, perturbations ou dysfonctionnement de toute nature, le Domaine suspend la vente pendant une durée raisonnable aux fins de permettre le suivi du protocole d'intervention mis en place avec le gestionnaire de la plate-forme. Titulaire d'une obligation de moyen, le Domaine ne peut toutefois garantir la restauration du système, l'origine des dysfonctionnements étant susceptible de qualifications plurales inhérentes aux aléas de ce mode de communication dont les utilisateurs acceptent les risques en reconnaissant qu'ils disposaient par ailleurs d'autres moyens de candidater tels qu'énumérés dans les présentes conditions générales de vente au nombre desquels la possibilité de se rendre sur les lieux ou de s'y faire représenter.

En cas d'impossibilité de rétablir la connexion dans le délai précité en raison du caractère indéterminé des dysfonctionnements constatés, le Domaine poursuit la vente avec le public présent en salle et les ordres d'achat préalablement reçus.

Aucun fait dommageable ne pouvant être mis à la charge du Domaine dans une situation irrésistible, imprévisible et insurmontable de cet ordre, sa responsabilité ne peut être utilement recherchée.

 

3.1.3/ Les ventes aux enchères en ligne ou online

Conditions de participation

Les ventes en ligne ou online proposent des lots en vente uniquement sur les plateformes de vente Drouot Digital ou Moniteur Live. Il n’y a pas d’exposition, sauf exception, ni de vente avec enchères verbales (cf § 3-1-1 et § 3-1-2). Les lots sont mis en vente pour une durée fixe et les utilisateurs peuvent enchérir pendant toute la durée de la vente.

Pour enchérir en ligne, l’utilisateur doit préalablement avoir créé un compte sur la plateforme de vente Drouot Digital ou Moniteur Live et être inscrit à la vente. La demande d'inscription de l'utilisateur pourra être validée jusqu'à l'heure de clôture de la vente précisée dans les conditions particulières de vente établies pour chaque vente. L’inscription est gratuite.

L’acheteur autorisé doit prendre toutes les mesures pour assurer la confidentialité de son identifiant et de son mot de passe ; il est responsable des actes et agissements de toute personne utilisant son compte, même à son insu. Il s’engage à signaler dans les plus brefs délais à la DNID toute utilisation frauduleuse de son compte, de son identifiant ou de son mot de passe.

Seules les personnes morales et personnes physiques disposant de la capacité juridique de contracter, sans limitation aucune, peuvent s’inscrire. Les mineurs ne sont pas autorisés à s’inscrire.

Une fois authentifié comme décrit supra, l’utilisateur a la possibilité d’enchérir. Dès lors, toute enchère enregistrée sur les plateformes de vente Drouot Digital ou Moniteur Live passée par le biais d’un identifiant et d’un mot passe valides sera réputée authentique et valide.

 

Suspension ou clôture de l’inscription

Sans exclure d’autres mesures coercitives, la DNID se réserve la possibilité de mettre fin temporairement ou définitivement à l’inscription de l’utilisateur :

– si les informations communiquées lors de l'inscription ne correspondent pas à la réalité ;

– s’il ne respecte pas tout ou partie des présentes conditions générales de vente ;

– si les enchères qu’il réalise ne sont pas effectuées dans le but d’acheter un bien et s’avèrent être de nature à perturber le bon fonctionnement du site ;

– s’il est vérifié que son identifiant et son mot de passe ont été transmis à des tiers.

 

Gestion des enchères en ligne

Dans le cadre d'une vente en ligne (online), la DNID peut être amenée :

– au retrait d’une annonce : la DNID conserve, à tout moment, la possibilité de retirer un bien mis en vente ;

– au retrait d’une enchère : la DNID se réserve le droit de retirer, sans préavis et sans indemnité, toute offre considérée comme déraisonnable ou excessive ;

– à l'annulation d'une enchère : la DNID se réserve le droit, dans le cas d'une vente restreinte à certaines catégories de professionnels, de ne pas déclarer adjudicataire l'enchérisseur ayant fait la meilleure offre et dans l'incapacité de produire les justificatifs visés à l'article 4.

L'enchérisseur professionnel remplissant les conditions détaillées à l'article 4 et ayant réalisé l'offre devenue en conséquence la plus élevée dans le cadre de la vente sera désigné, après son acceptation, adjudicataire.

Des informations supplémentaires sur les biens peuvent être obtenues en s’adressant (par courriel ou par téléphone) au commissariat aux ventes dont les cordonnées sont indiquées dans la page de présentation sur le site internet encheres-domaine.gouv.fr. Aucune visite sur place n’est organisée, sauf exception.

En cas d’interruption de service (problème technique), dûment constatée par l’hébergeur, qui rend impossible l’accès à une enchère à moins de 4 heures de sa clôture, la DNID se réserve le droit de prolonger la période d’enchère ou d’annuler l’enchère pour la relancer ultérieurement.

 

Fonctionnement des enchères automatiques sur les plateformes Drouot Digital et Moniteur Live

Un système d’enchère automatique (depuis la fiche de lot, cliquez sur « Enchère automatique ») permet à l’intéressé qui le souhaite de se dispenser de connexion pour surenchérir à chaque fois que son enchère est dépassée. Il lui suffit d’indiquer le montant maximal qu’il est disposé à payer pour acquérir le lot, et le système s’occupe du reste. Le montant de son enchère maximum n’est pas communiqué à la DNID ni aux autres enchérisseurs.

Le système enchérit automatiquement en respectant le pas d’enchère. Le système surenchérit du montant nécessaire pour que l’offre reste toujours la plus élevée.

Si un autre adjudicataire enchérit pour un montant identique ou définit une enchère maximum supérieure, l’adjudicataire ayant la plus faible enchère reçoit un courriel signalant que quelqu’un a surenchéri sur le lot pour qu’il puisse augmenter son offre. En revanche, si personne ne propose d’enchère supérieure avant la fin de la vente, l’adjudicataire remporte le lot pour un prix qui sera inférieur à son enchère maximum.

En fin de vente, un courriel récapitulatif de ses achats sera adressé à l’adjudicataire.

 

Retrait du bien

Le retrait du lot vendu est à la charge de l’acheteur. Il n’interviendra que lorsque le montant de l’adjudication aura été réglé.

Une remise au transporteur de votre choix des biens exposés au magasin domanial d’Île-de-France de la DNID est possible sur demande écrite. L'expédition est au frais et sous la responsabilité de l'adjudicataire.

Sur simple demande, la DNID peut communiquer, de manière non contractuelle, les coordonnées d'un courtier en logistique ou d’une place de marché internet assurant l'emballage et le transport de votre bien.

 

3.1.4 / L’ordre d’achat

L'ordre d'achat peut être sous forme matérialisée (ordre d'achat « papier »), ou dématérialisée (ordre d'achat « en ligne »).

Il doit faire apparaître clairement la date de la vente, les coordonnées complètes de l'enchérisseur, le numéro du lot concerné et sa désignation.

L'ordre d'achat étant un service, le Domaine décline toute responsabilité notamment en cas d'erreur ou d'omission d'exécution.

Ordre d'achat « papier »

Il est obligatoirement établi selon le modèle disponible en ligne (modèle) ou disponible dans les commissariats aux ventes.

L'ordre d'achat ne pourra être accepté qu'après validation des inscriptions au vu des documents suivants :

– pour les personnes physiques, de la copie d'une pièce d'identité en cours de validité,

– si le lot souhaité est réservé à un professionnel, de la copie d'un document attestant de cette qualité.

Il doit obligatoirement être accompagné d'un chèque d'acompte de 10% du montant prévisionnel hors taxe auquel l'enchérisseur envisage acquérir le lot, avec un plafond à 1500€.

Il doit être porté à la connaissance du commissaire aux ventes avant la date et l'heure indiquées sur les notices de vente et le site internet des ventes du Domaine, sous enveloppe cachetée, au siège du CAV qui organise la vente.

L'enveloppe cachetée portera la mention : « ordre d'achat pour la vente du ............... à .......................... » et comprendra, outre l'ordre d'achat et le chèque, une enveloppe au nom et adresse de son émetteur affranchie au tarif en vigueur. Les chèques des ordres d'achat non retenus seront renvoyés.

Après ouverture de la vente aux enchères, l'ordre d'achat écrit régulier ne peut être ni retiré, ni modifié.

Ordre d'achat « en ligne »

L'ordre d'achat ne pourra être accepté qu'après validation des inscriptions au vu des documents précités.

Il doit être accompagné d'une garantie de 10% du montant prévisionnel hors taxe auquel l'enchérisseur envisage acquérir le lot.

En cas de stricte égalité entre l'offre d'achat écrite la plus élevée et la dernière enchère verbale, le lot est adjugé à l'enchérisseur verbal.

3.2 Les cessions amiables avec publicité et concurrence (marché d’enlèvement)

Certains biens peuvent être aliénés avec publicité et concurrence hors le périmètre d’une salle des ventes, en ajoutant éventuellement au critère « prix » d’autres critères pour sélectionner l’acquéreur.

Une telle vente est désignée sous les termes « appel d’offres » ou « marché d’enlèvement ».

Les ventes sur support écrit (marchés d’enlèvement / appels d’offres) sont également soumises à des CPV précisées dans le CCP accessible sur le site dédié aux ventes mobilières domaniales.

Au terme de la procédure, la commission d'attribution des ventes domaniales examine les offres. L'identité de l'acquéreur, le contenu ou le montant des offres ne sont pas communiqués.

En cas de circonstances exceptionnelles ou de force majeure (ex : période d'épidémie, restriction des déplacements, catastrophe climatique...), les modalités de dépôt des offres pourront être adaptées. Les acheteurs devront alors se conformer aux mentions détaillées dans le cahier des charges particulières propres à chaque appel d'offres ou marché d'enlèvement mis en ligne sur le site "encheres-domaine.gouv.fr ou se reporter aux modalités modifiées publiées sur le site "encheres-domaine.gouv.fr" si l'évènement survient après la publication du cahier des charges particulières.

CONDITIONS POUR PARTICIPER AUX VENTES
4.1 Participation à titre personnel

La participation aux ventes peut être restreinte à des catégories de professionnels.

Cette restriction concerne les biens dont la vente est soumise à des règles spéciales d’ordre juridique ou prudentiel précisées dans les CPV de la vente. La mention « Réservé aux professionnels » ou un logo « RP » signale dans les CPV les lots concernés par une restriction.

La principale activité mentionnée dans l'extrait K-bis (ou équivalent) détermine la nature des lots pour lesquels le professionnel pourra enchérir.

La participation aux ventes en direct sur Internet est soumise à une procédure d'inscription préalable.

L'inscription aux ventes en direct devra se faire au plus tard à 12h00 le dernier jour ouvré avant la vente sur les sites plateformes DROUOT Live ou MONITEUR Live.

Pour les personnes morales et les professionnels, l'extrait K-bis devra être envoyé au plus tard à 16h00 la veille de la vente (le vendredi 11h00 pour les ventes organisées le lundi).

Pour les particuliers, une pièce d'identité en cours de validité devra être envoyée dans les mêmes conditions.

L'adresse électronique fournie lors de l’inscription sera utilisée pour l'envoi des différents échanges et documents de vente (avis de paiement / bordereau d'achat / autorisation d'enlèvement). Pour les véhicules, la facture et/ou le certificat de vente seront envoyés par courriel.

La participation aux ventes en ligne sur internet est soumise à une procédure d’inscription préalable.

L’inscription à la vente est gratuite et est réalisée à partir de la plateforme de vente Moniteur Live ou Drouot Digital.

Les personnes morales et les professionnels devront, en vue de leur inscription, déposer sur la plateforme Moniteur Live ou Drouot Digital un extrait K-bis de moins de 12 mois et une copie d'une pièce d'identité.

Les particuliers devront, en vue de leur inscription, déposer sur la plateforme Moniteur Live ou Drouot Digital, une pièce d'identité en cours de validité.

L’utilisateur devra par ailleurs renseigner le numéro de sa carte bancaire.

L'adresse électronique fournie lors de l’inscription sera utilisée pour l'envoi des différents échanges et documents de vente (facture / situation de paiement / autorisation d'enlèvement).

La participation aux ventes en ligne sur internet est soumise à une procédure d'inscription préalable.

L'inscription à la vente est gratuite et est réalisée à partir de la plateforme de vente Moniteur Live ou Drouot Digital.

Les personnes morales et les professionnels devront, en vue de leur inscription, déposer sur la plateforme Moniteur Live ou Drouot Digital un extrait K-bis de moins de 12 mois et une copie d'une pièce d'identité.

Les particuliers devront, en vue de leur inscription, déposer sur la plateforme Moniteur Live ou Drouot Digital, une pièce d'identité en cours de validité.

L'utilisateur devra par ailleurs renseigner le numéro de sa carte bancaire.

L'adresse électronique fournie lors de l'inscription sera utilisée pour l'envoi des différents échanges et documents de vente (facture/situation de paiement/autorisation d'enlèvement).

4.2 Sécurité des ventes

Les CPV précisent la capacité maximale d’accueil de la salle des ventes conformément à la réglementation ERP (Établissement Recevant du Public).

Par ailleurs, lorsque les ventes se déroulent sur une période au cours de laquelle le plan VIGIPIRATE est activé, un contrôle visuel du contenu des sacs est effectué à l’entrée de la salle d’exposition et de la salle des ventes. Outre ce contrôle, l’accès à la salle d'exposition est subordonné à la présentation d'une pièce d'identité.

4.3 Achat pour le compte d'un tiers

Une procuration est requise pour enchérir et payer pour un tiers.

Un modèle de procuration, qui précise les pièces à produire à l'appui, peut être téléchargé sur le site Internet des ventes du Domaine .

En cas de participation à la vente de plusieurs lots, une procuration est établie par lot.

4.4 Justificatifs à produire

Identité

Pour les personnes physiques, l'adjudication est subordonnée à la présentation d'une pièce d'identité avec photographie.

Pour les personnes morales, l 'adjudication est subordonnée à la présentation de l'original et au dépôt d'une copie :

– De l'inscription au Registre du Commerce et des sociétés (K ou Kbis) ou au Répertoire des Métiers (extrait D1) datée de moins de 12 mois pour toutes les entreprises françaises ou pour les entreprises étrangères, son équivalent étranger traduit en français par un traducteur officiel agréé en France ou par l'Ambassade en France du pays d’origine

- Des statuts de l’association, si la personne représente une association

- D’un pouvoir signé par le dirigeant ou son conseil d’administration autorisant le signataire à engager la société. Il doit également présenter une pièce d’identité.

 

Qualité de professionnel

L’acquéreur doit prouver sa qualité de professionnel en justifiant l’exercice d’une activité dont la codification dans la Nomenclature des Activités Françaises (NAF) correspond à celle qui est requise dans les CPV de la vente concernée.

 

Candidats étrangers

Les candidats étrangers sont astreints au dépôt des mêmes pièces ou à leur équivalent selon la législation de l’État dont ils sont ressortissants.

Les documents étrangers, non établis en français, doivent obligatoirement être accompagnés de leur traduction en langue française par un traducteur agréé ou assermenté.

La liste des traducteurs agréés peut être consultée sur le site internet de la Cour de cassation.

4.5 Sanctions en cas de non-respect du bon déroulement de la vente

Les acheteurs dont le comportement préjudicie au bon déroulement des ventes du Domaine encourent des sanctions déclinées selon la gravité des manquements dans une table des sanctions prévue au CCAG, publiée sur le site des ventes domaniales et affichée en salle. La sanction maximale encourue est une exclusion des ventes pour une durée de 3 ans.

CONDITIONS DE PAIEMENT
5.1 Le prix de vente

L'adjudicataire paiera le prix principal de son enchère augmenté des frais constitués par l'application d'une taxe domaniale forfaitaire fixée par arrêté ministériel.

Le montant des frais est différent selon que le lot est mis en vente aux enchères ou par cession amiable :

– pour les lots mis en vente aux enchères, la taxe est de 11 %

– pour les lots mis en vente par voie de cessions amiables avec publicité et mise en concurrence, la taxe est de 6 %

En outre, si la vente est passible de la T.V.A. (lorsque le service vendeur est soumis à la T.V.A. ou le régime des biens d'occasion ne s'applique pas), il devra acquitter le montant de cette taxe sur la base du prix principal augmenté de la taxe domaniale.

Aucun lot ne sera remis aux acquéreurs avant le paiement de l'intégralité des sommes dues.

 

5.2 Le paiement du prix

La vente par adjudication est faite au comptant

Le jour de la vente, les lots adjugés jusqu’à 300 € doivent être réglés en totalité. Pour les adjudications d'un montant supérieur, en l’absence de paiement total, il est exigé un acompte de 10 % du prix (plafonné à 1 500 €).

Le paiement du prix de vente devra avoir lieu au plus tard le 8ème jour suivant la vente et avant enlèvement des lots.

Le manquement à une de ces obligations entraînera la résolution de la vente. L'acompte sera conservé.

Les modes de paiement proposés

Pour des raisons de sécurité des transactions, les paiements en espèces et par chèque ne sont pas acceptés mais d'autres moyens sont proposés pour le paiement des achats, qu'ils soient effectués sur place ou par internet :

Lors de la vente :

– par carte bancaire : il est conseillé aux acheteurs de faire déplafonner, le cas échéant, leur carte auprès de leur établissement bancaire

– pour les internautes inscrits aux ventes live, par prélèvement en ligne sur DrouotLIVE ou MoniteurLIVE.

Dans les 8 jours de la vente :

– par virement : les acquéreurs doivent tenir compte du délai de traitement des virements internationaux pour respecter le délai de paiement de 8 jours. Les virements ne deviennent effectifs que lorsqu'ils sont crédités sur ledit compte

– par carte bancaire à la caisse de la régie

– pour les internautes inscrits aux ventes live ou online par prélèvement en ligne sur DrouotLIVE ou MoniteurLIVE.

En cas de circonstances exceptionnelles ou de force majeure (ex: période d'épidémie, restriction des déplacements, catastrophe climatique...), les modalités de paiement du prix pourront être adaptées.

Les acheteurs devront alors se conformer aux mentions détaillées dans le cahier des charges particulières ou dans les conditions particulières de vente propres à chaque vente et mis en ligne sur le site "encheres-domaine.gouv.fr" ou se reporter aux modalités modifiées publiées sur le site "encheres-domaine.gouv.fr" si l'évènement survient après la publication du cahier des charges particulières ou des conditions particulières de vente.

 

La vente par marché d'enlèvement

Ce type de vente est généralement passé sur support écrit. Le dépôt par le soumissionnaire d’un chèque d’acompte au moins égal à 10 % du montant de l'offre hors taxe domaniale, pourra être exigé dans les CPV lors du dépôt de l’offre.

Après dépouillement des offres reçues, le soumissionnaire retenu doit régler la totalité des sommes dues au plus tard le 8ème jour suivant la date de notification de son offre.

Le manquement à ces obligations entraînera la résolution de la vente. Dans le cas où le versement d’un acompte est exigé, l'acompte sera conservé.

Le prix du marché est régularisé à la fin du marché en fonction de la quantité réellement enlevée, si tel est son objet.

 

Conditions spécifiques aux ventes en direct sur Internet

Conditions de paiement

Paiement comptant pour les ventes par adjudication jusqu'à 300€ (par lot). Pour celles supérieures à 300 €, un acompte de 10% du prix devra être versé le jour de la vente.

Provision de 10%

Pour garantir le versement de l'acompte, l'internaute doit, lors de l'inscription, saisir sa carte bancaire pour une transaction 3DSecure non débitée de deux euros.

Pour sécuriser la transaction, une empreinte équivalente à 10% du montant prévisionnel des achats sera à saisir.

Par exemple :

– Si vous voulez acquérir un véhicule et vous vous êtes fixé un budget de 5 000€, vous devrez laisser une empreinte d'au moins 500€.

La totalité de la somme que vous aurez laissée en provision sera prélevée le soir de la vente dans la limite du montant total dû (taxe domaniale incluse) à titre d'acompte.

Il vous appartiendra de régler le solde sous 8 jours . Un courriel de la régie vous confirmera le montant dû.

– Vous avez choisi de provisionner 1 000 € .Vous avez obtenu un véhicule pour un prix adjugé de 3 500€ HT (soit 3 885 €TDI).La somme de 1 000 € sera prélevée le soir de la vente. Il vous appartiendra de régler le solde, à savoir 2 885 € sous 8 jours.

– Vous avez choisi de provisionner 1 000 €. Vous avez obtenu un véhicule pour un prix adjugé de 800 €. La somme de 888 € (prix de vente +taxe domaniale de 11%) sera prélevée le soir de la vente. Aucun solde ne devra être réglé.

 

En cas de circonstances exceptionnelles ou de force majeure (ex: période d'épidémie, restriction des déplacements, catastrophe climatique...), les modalités de paiement du prix pourront être adaptées.

Les acheteurs devront alors se conformer aux mentions détaillées dans le cahier des charges particulières ou dans les conditions particulières de vente propres à chaque vente et mis en ligne sur le site "encheres-domaine.gouv.fr" ou se reporter aux modalités modifiées publiées sur le site "enchères-domaine.gouv.fr" si l'évènement survient après la publication du cahier des charges particulières ou des conditions particulières de vente.

ABSENCE DE GARANTIE, CONDITIONS DE VISITE ET D'ENLÈVEMENT
6.1 Absence de garantie

Les ventes domaniales sont effectuées sans garantie. L’acquéreur en contractant accepte de prendre les matériels ou marchandises en l'état, dans leur lieu de stockage.

6.2 Visite

Les descriptions des biens objets de la vente sont données à titre indicatif et ne sont pas contractuelles.

Elles appellent donc à être vérifiées par l'acquéreur.

Il incombe à l'acquéreur de s'informer sur l'état du bien, de ses caractéristiques ainsi que de l'usage qu'il peut en attendre. Il lui appartient de le visiter.

S'il n'a pas accompli les diligences habituelles et normales, il ne pourra être reproché au vendeur de ne pas l'avoir informé.

A cette fin, une exposition préalable permet aux acquéreurs de se rendre compte de l'état des biens mis en vente. Les conditions de visite sont indiquées dans les CPV.

Pour des raisons de sécurité, l'accès aux expositions organisées par les CAV est subordonné à la présentation d'une pièce d'identité.

En déposant une offre d'achat après visite du bien, l'acquéreur reconnaît avoir été valablement informé et qu'il est pleinement satisfait de l'état des biens.

En cas de circonstances exceptionnelles ou de force majeur (ex: période d'épidémie, restriction des déplacements, catastrophe climatique...), les modalités de visite pourront être adaptées.

Les acheteurs devront alors se conformer aux mentions détaillées dans le cahier des charges particulières ou dans les conditions particulières de vente propres à chaque vente et mis en ligne sur le site "encheres-domaine.gouv.fr" ou se reporter aux modalités modifiées publiées sur le site "encheres-domaine.gouv.fr" si l'évènement survient après la publication du cahier des charges particulières ou des conditions particulières de vente.

6.3 Enlèvement

Les conditions d’enlèvement sont indiquées dans les CPV. A défaut d’indication particulière, le délai imparti à l'acquéreur pour procéder à l'enlèvement des objets vendus ne peut excéder 20 jours à compter :

– du jour de l’adjudication

– du jour de la notification de l’approbation de l’offre écrite.

Le manquement à cette obligation entraînera la résolution de la vente. Le paiement sera conservé.

En cas de circonstances exceptionnelles ou de force majeur (ex: période d'épidémie, restriction des déplacements, catastrophe climatique...), les modalités de visite pourront être adaptées.

Les acheteurs devront alors se conformer aux mentions détaillées dans le cahier des charges particulières ou dans les conditions particulières de vente propres à chaque vente et mis en ligne sur le site "encheres-domaine.gouv.fr" ou se reporter aux modalités modifiées publiées sur le site "encheres-domaine.gouv.fr" si l'évènement survient après la publication du cahier des charges particulières ou des conditions particulières de vente.

BIENS SOUMIS À UNE RÉGLEMENTATION OU DES CONDITIONS DE VENTE SPÉCIFIQUES
.1 Véhicules

L'ensemble des formalités nécessaires au dédouanement, à l'immatriculation et à la mise en circulation des véhicules est à la charge de l'acquéreur.

Seuls les véhicules vendus avec certificat d'immatriculation et contrôle technique en cours de validité sont autorisés à circuler avant leur réimmatriculation. Tout autre véhicule doit impérativement être enlevé sur plateau.

Les véhicules vendus sans certificat d'immatriculation sont signalés par un logo « ACI » (Absence de Certificat d'Immatriculation)». Il n'est pas possible de circuler avec ces véhicules avant d'avoir procédé aux formalités d'immatriculation décrites à l'article 12.B de l'arrêté du 9 février 2009 (ou à l'article 12.E pour les véhicules étrangers non réceptionnés au plan communautaire).

Certains véhicules militaires ne sont pas enregistrés au fichier civil SIV et sont dépourvus de certificat de conformité à un type CE . En l'état, leur circulation est interdite sur la voie publique.

Le kilométrage indique le total parcouru s'il s'agit d'un véhicule acquis neuf par le vendeur ou s'il peut être justifié ; sinon le kilométrage au compteur est suivi de la mention « non garanti ».

Les véhicules gardés en fourrière suite à abandon ou décision de Justice sont d'état mécanique inconnu et dépourvus de clé, sauf mention contraire dans le descriptif du lot. Tout travail sur le parc est interdit. Les acquéreurs doivent acquitter les frais de garde au tarif en vigueur à compter du lendemain de la vente.

Les voitures particulières, les camionnettes et cyclomoteurs à 3 roues non réimmatriculables sont signalés par un logo « NR ». Seuls peuvent les acquérir les professionnels de la déconstruction automobile titulaires de l'agrément préfectoral se rapportant aux installations classées (art. R543-162 du Code de l'Environnement). L ’adjudication est subordonnée à la présentation de l'original et au dépôt d’ une copie de l ' agrément en cours de validité. Aucun certificat de vente n'est délivré.

Les véhicules dont la désignation dans le corps de l'annonce est précédée du logo « RP » restreint la capacité d'enchérir à des professionnels disposant des justificatifs d'activité requis.

Aucun certificat de vente n'est délivré aux acquéreurs de véhicules non homologués pour circuler sur route (quads, buggy, motocross ,...).

7.2 Navigation

Les modalités d'immatriculation auprès de la DDTM et des Douanes sont à la charge exclusive de l'acquéreur .

7.3 Machines-outils

Seules les machines outils conformes aux standards réglementaires de mise en place, d’utilisation, de réglage et de maintenance peuvent être vendues 1 :

– La vente des machines outils pourvues d’une attestation de conformité aux règles d’hygiène et de sécurité prévues à l’annexe 1 de l’article R4312-1 du code du travail s’adresse à tout professionnel dont l'activité est liée à leur destination.

– La vente des machines outils dépourvues de l’attestation visée à l’alinéa précédent à pour objet leur remise en conformité. En conséquence, la vente est circonscrite aux pièces détachées composant la machine initiale et s’adresse aux seuls professionnels agissant en qualité de négociants en machines outils disposant des justificatifs d’activité requis. Les lots sont signalés par le logo « NC » (Non conforme).

– La vente des machines outils dépourvues de l’attestation visée ci-dessus et non susceptibles de remise en conformité a pour objet leur destruction. En conséquence, la vente est circonscrite aux seules matières premières recyclables contenues dans les pièces de la machine initiale et s’adresse aux seuls professionnels agissant en qualité de ferrailleurs et disposant des justificatifs d’activité requis.

7.4 Ordinateurs, téléphones et autres appareils dotés de mémoire interne

Les objets sont susceptibles de contenir des données concernant la vie privée de leurs anciens propriétaires. L’acquéreur s’engage à ne pas divulguer ces éléments privés et à vider ou faire vider, sous sa responsabilité, les mémoires internes des objets avant toute utilisation, cession ou transmission de ceux-ci.

7.5 Matériel aéronautique

Indépendamment du certificat de navigabilité qui peut être obtenu en France auprès de la Direction Générale de l’Aviation Civile (DGAC GSAC), les acquéreurs doivent systématiquement s’assurer que l’appareil acheté ou remonté est apte au vol, c’est-à -dire qu’il répond aux conditions techniques de navigabilité ayant servi de base à la délivrance du document de navigabilité qui lui est propre et aux règles de maintien en état de validité de ce document (article R133-1 du code de l’aviation civile).

En conséquence, les acquéreurs sont systématiquement invités à soumettre les matériels à l'examen du constructeur concerné avant leur utilisation. Cette expertise est indispensable pour s'assurer de la navigabilité des matériels, de leur mise aux normes civiles pour les matériels d'origine militaire.

L’acquéreur devra en outre veiller à ce que ces recommandations soient portées explicitement à la connaissance d’éventuels sous-acquéreurs.

7.6 Matériel de guerre

 

Les armes et matériels de guerre de catégorie A2 ne peuvent être vendus qu’aux professionnels de l’armement agréés par l’État. Les professionnels concernés doivent justifier être titulaires d’une Autorisation de Fabrication et de Commerce (AFC) de matériel, armes et munitions de catégorie A accordée par le ministre de la Défense, en cours de validité et dont les rubriques correspondent à la classification des armes et matériels concernés par la vente.

1Application des articles L4311-3, L4741-9 et R4312-1 du code du travail

Arrêté du 21 novembre 2017 relatif au cahier des clauses administratives générales des ventes des biens mobiliers par le Domaine.

Cahier des clauses administratives générales des ventes des biens mobiliers par le Domaine.</p>

<p>CONDITIONS GÉNÉRALES DES VENTES IMMOBILIÈRES
VENTES RÉALISÉES PAR LE DOMAINE
1 - VISITES ET CAHIER DES CHARGES

Les conditions dans lesquelles il est possible de visiter l’immeuble et de consulter le CAHIER DES CHARGES sont indiquées dans chaque annonce.

2 - PERSONNES ADMISES À ENCHÉRIR

Tous les amateurs peuvent enchérir, à l’exception des personnes qui ont été exclues des ventes domaniales. Les personnes étrangères ou résidant à l’étranger doivent se conformer à la réglementation française des changes ; toutes précisions utiles leur seront fournies par la Direction désignée dans la publicité.
Toute personne se présentant pour autrui devra déposer avant la vente une PROCURATION certifiée par le mandataire et justifier de son identité et de son domicile.

3 - PIÈCES JUSTIFICATIVES NÉCESSAIRES POUR PARTICIPER À L’ADJUDICATION

- Les particuliers doivent présenter une carte d’identité en cours de validité et un justificatif du domicile (facture EDF ou de téléphone ou quittance de loyer, ou domiciliation chez un officier ministériel).
- Les professionnels doivent présenter un Kbis de moins de 3 mois, et indiquer la date de déclaration d’existence et l’adresse du centre des impôts concerné.
- Les sociétés doivent présenter un extrait Kbis de moins de 3 mois, les pouvoirs du mandataire, et les statuts certifiés conformes à l’original par le dirigeant de la société.

4 - MODE D’ADJUDICATION

Les amateurs ou leurs représentants doivent être présents à la séance. Ils portent les enchères eux-mêmes sans intervention obligatoire d’un notaire ou d’un avocat.
Le bien est adjugé aux enchères verbales et à l’extinction des feux, au profit du plus offrant, après que deux feux se soient éteints successivement sur une même enchère dont le montant minimum est précisé dans le cahier des charges.
La mise à prix est toujours annoncée et doit être obligatoirement couverte par l’enchère minimale. Les soumissions ne sont pas acceptées. Les adjudications sont définitives sauf l’exercice éventuel de droits de préemption.
Il n’y a pas de DROIT DE SURENCHERE.

5 - RÉSERVES

L’adjudicataire prendra le bien dans l’état où il le trouvera au moment de l’entrée en jouissance.
Pour les lots en copropriété la superficie est déterminée en application de la réglementation édictée par la loi CARREZ.
Ne sont pas concernés par celle-ci les caves, garages, emplacements de stationnement ainsi que les lots de copropriété d’une superficie inférieure à 8 m2.
Pour les autres immeubles la vente est faite sans garantie de mesure et de consistance et l’adjudicataire ne pourra exercer aucun recours en réduction de prix ou en indemnité, à l’exception du cas où la différence en moins de la superficie excéderait un vingtième (1/20ème).

6 - FRAIS À PAYER EN SUS DU PRIX

Les frais préalables à la vente ne sont pas à la charge de l’adjudicataire (frais de publicité, renseignements hypothécaires, et certificat d’urbanisme) de même que les frais de photocopie des règlements de copropriété. L’adjudicataire doit payer, en sus du prix, la taxe de publicité foncière, les taxes additionnelles, les salaires du conservateur des hypothèques, les droits de timbre du procès-verbal d’adjudication et des annexes, ainsi que le coût de deux expéditions.

7 - MODE DE PAIEMENT DU PRIX ET DES FRAIS

Sauf modalités particulières inscrites au cahier des charges.

Si le prix n’excède pas 15 000 €, l’acquéreur aura un délai d’un mois pour se libérer.

Au dessus de 15 000 € et jusqu’à 75 000 €, le prix pourra être payé en deux fractions égales, la première dans un délai d’un mois à compter de l’adjudication et la deuxième dans un délai supplémentaire de deux mois. Ce prix sera majoré de l’intérêt au taux légal.

Au-dessus de 75 000 €, il sera payable de la manière suivante :

1º) un tiers, dans le mois de la vente, sans intérêts ;
2º) un second tiers, dans un délai supplémentaire de deux mois, avec intérêts au taux légal ;
3º) le solde, dans un délai complémentaire de trois mois, de telle sorte que le prix total soit versé dans un délai maximum de six mois à compter du jour de l’adjudication, avec intérêts au taux légal.

Une inscription de privilège auprès du bureau des hypothèques sera prise si le prix n’est pas payé en totalité dans le mois de la vente (4 mois pour les ventes organisées par la DNID).

Les droits de timbre, les salaires du conservateur des hypothèques, la taxe de publicité foncière et les taxes annexes doivent être payés, en toute hypothèse, dans le mois, à la caisse du Receveur désigné.
Pour remplir les formalités préalables à son entrée en jouissance, l’adjudicataire a un délai d’un mois, pendant lequel il ne paie pas d’intérêt ; passé ce délai, les sommes restant dues portent intérêt au taux légal.

8 - CAUTIONNEMENT POUR ENCHÉRIR

Sauf modalités particulières inscrites au cahier des charges.

L’amateur d’un lot dont la mise à prix est supérieure à 7 500 € ne peut être admis à enchérir que s’il a versé un cautionnement de 5 % du montant de la mise à prix (20 % pour les ventes organisées par la DNID).
Ce cautionnement sera versé au moyen d’un chèque de banque (établi par la banque) ou d’un chèque postal certifié par la Poste. Le chèque (de banque ou postal) doit être établi à l’ordre du TRESOR PUBLIC.

Les chèques de cautionnement sont à déposer à l’ouverture de la séance. Aucun autre mode de paiement n’est accepté. Le montant du cautionnement sera imputé sur celui du premier terme du prix ou restitué immédiatement aux personnes qui n’auront pas été déclarées adjudicataires.

9 - NON-PAIEMENT DU PRIX, POURSUITES, DÉCHEANCES

A défaut de paiement du prix et des frais, il y a lieu à poursuites par toutes les voies légales au moyen, le cas échéant, de la procédure de recouvrement des impôts. Le Domaine peut, s’il le préfère, recourir à la résolution de la vente par application de la procédure de déchéance.

VENTES RÉALISÉES PAR UN NOTAIRE OU AU TRIBUNAL
Lorsque la vente est effectuée par un notaire ou à la barre du tribunal de grande instance, elle est soumise à des conditions différentes qui sont indiquées dans le cahier des charges.
En particulier, les adjudications peuvent être frappées de surenchère. D’autre part, en sus du prix, l’adjudicataire aura à payer :

- les frais préalables à la vente,
- la taxe de publicité foncière,
- les honoraires revenant au notaire ou à l’avocat.

Au tribunal, l’assistance d’un avocat pour porter les enchères est obligatoire.</p>
<button onclick="rtn()">Retour à la page précédente</button>
<script>
function rtn() {
   window.history.back();
}
</script>
		<%@include file="fragment/bouttonRetourAccueil.jsp"%>
	</main>
		<%@include file="fragment/footer.jsp"%>
</body>
</html>