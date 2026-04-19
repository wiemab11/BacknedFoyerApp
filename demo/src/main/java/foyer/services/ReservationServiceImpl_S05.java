// === CE FICHIER EST UN EXTRAIT — A FUSIONNER AVEC LE FICHIER COMPLET DU MEMBRE 5 ===
// Méthode Service 05 à ajouter dans ReservationServiceImpl.java

/*
    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(
            Long numChambre, String cin) {

        Chambre chambre = chambreRepo.findByNumeroChambre(numChambre);
        Etudiant etudiant = etudiantRepo.findByCin(Long.parseLong(cin));

        // Vérifier capacité max selon le type de chambre
        int capaciteMax = switch (chambre.getTypeC()) {
            case SIMPLE -> 1;
            case DOUBLE -> 2;
            case TRIPLE -> 3;
        };

        long reservationsActives = chambre.getReservations()
                .stream().filter(Reservation::isEstValide).count();

        if (reservationsActives >= capaciteMax) {
            throw new RuntimeException("Capacité maximale atteinte pour la chambre " + numChambre);
        }

        // Construire l'année universitaire
        int year = LocalDate.now().getYear() % 100;
        String anneeUniv;
        if (LocalDate.now().getMonthValue() <= 7) {
            anneeUniv = "20" + (year - 1) + "/20" + year;
        } else {
            anneeUniv = "20" + year + "/20" + (year + 1);
        }

        // ID format: "2024/2025-BlocA-1-123456789"
        String nomBloc = (chambre.getBloc() != null) ? chambre.getBloc().getNomBloc() : "SansBloc";
        String idReservation = anneeUniv + "-" + nomBloc + "-" + numChambre + "-" + cin;

        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(LocalDate.now());
        reservation.setEstValide(true);
        reservation.getEtudiants().add(etudiant);

        Reservation saved = reservationRepo.save(reservation);
        chambre.getReservations().add(saved);
        chambreRepo.save(chambre);
        return saved;
    }
*/
