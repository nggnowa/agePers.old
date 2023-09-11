package com.dresen.agePers.enseignant;

import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.diplome.Diplome;
import com.dresen.agePers.discipline.Discipline;
import com.dresen.agePers.enseignant.enums.*;
import com.dresen.agePers.etablissement.Etablissement;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.grade.Grade;
import com.dresen.agePers.poste.Poste;
import com.dresen.agePers.region.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EnseignantService implements IEnseignantService {

    private final EnseignantDtoMapper dtoMapper;

    private EnseignantRepository repository;

    @Override
    public EnseignantDto createEnseignant(EnseignantDto enseignantDto) {

        Optional<Enseignant> enseignantByMatricule = repository.findEnseignantByMatricule(enseignantDto.matricule());
        Optional<Enseignant> enseignantByEmail     = repository.findEnseignantByEmail(enseignantDto.email());

        if (enseignantByMatricule.isPresent()) {

            throw new ResourceTakenException(Enseignant.class.getSimpleName(), "matricule", enseignantDto.matricule());
        }

        if (enseignantByEmail.isPresent()) {

            throw new ResourceTakenException(Enseignant.class.getSimpleName(), "email", enseignantDto.email());
        }

        Enseignant enseignant = new Enseignant(
                enseignantDto.id(),
                enseignantDto.nom(),
                enseignantDto.sexe(),
                enseignantDto.dateNaissance(),
                enseignantDto.lieuNaissance(),
                enseignantDto.matricule(),
                enseignantDto.categorie(),
                enseignantDto.statut(),
                enseignantDto.dateEntreeService(),
                enseignantDto.anciennete(),
                enseignantDto.dateRetraite(),
                enseignantDto.langueTravail(),
                enseignantDto.presence(),
                enseignantDto.telephone(),
                enseignantDto.email(),
                enseignantDto.statutMedical(),
                enseignantDto.statutMatrimonial(),
                enseignantDto.nombreEnfant(),
                enseignantDto.regionOrigine(),
                enseignantDto.departementOrigine(),
                enseignantDto.arrondissementOrigine(),
                enseignantDto.ethnie(),
                enseignantDto.grade(),
                enseignantDto.formation(),
                enseignantDto.discipline(),
                enseignantDto.diplomes()
        );

        Enseignant savedEnseignant = repository.save(enseignant);
        return dtoMapper.apply(savedEnseignant);
    }

    @Override
    public EnseignantDto getEnseignantById(Long id) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(enseignant);
    }

    @Override
    public EnseignantDto getEnseignantByMatricule(String matricule) {

        Enseignant enseignant = repository.findEnseignantByMatricule(matricule).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "matricule", matricule)
        );

        return dtoMapper.apply(enseignant);
    }

    @Override
    public List<EnseignantDto> getAllEnseignants() {

        List<Enseignant> enseignants = repository.findAll();
        return enseignants.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public List<EnseignantDto> getEnseignantsByDiplomeId(Long diplomeId) {

        List<Enseignant> enseignants = repository.findEnseignantsByDiplomesId(diplomeId);
        return enseignants.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public EnseignantDto updateEnseignant(Long id, EnseignantDto enseignantDto) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setNom(enseignantDto.nom());
        enseignant.setSexe(enseignantDto.sexe());
        enseignant.setDateNaissance(enseignantDto.dateNaissance());
        enseignant.setLieuNaissance(enseignantDto.lieuNaissance());
        enseignant.setMatricule(enseignantDto.matricule());
        enseignant.setCategorie(enseignantDto.categorie());
        enseignant.setStatut(enseignantDto.statut());
        enseignant.setDateEntreeService(enseignantDto.dateEntreeService());
        enseignant.setLangueTravail(enseignantDto.langueTravail());
        enseignant.setPresence(enseignantDto.presence());
        enseignant.setTelephone(enseignantDto.telephone());
        enseignant.setEmail(enseignantDto.email());
        enseignant.setStatutMedical(enseignantDto.statutMedical());
        enseignant.setStatutMatrimonial(enseignantDto.statutMatrimonial());
        enseignant.setNombreEnfant(enseignantDto.nombreEnfant());
        enseignant.setRegionOrigine(enseignantDto.regionOrigine());
        enseignant.setDepartementOrigine(enseignantDto.departementOrigine());
        enseignant.setArrondissementOrigine(enseignantDto.arrondissementOrigine());
        enseignant.setEthnie(enseignantDto.ethnie());
        enseignant.setFormation(enseignantDto.formation());
        enseignant.setDiscipline(enseignantDto.discipline());
        enseignant.setDiplomes(enseignantDto.diplomes());

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantIidentite(Long id, String nom, Sexe sexe, LocalDate dateNaissance, String lieuNaissance) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setNom(nom);
        enseignant.setSexe(sexe);
        enseignant.setDateNaissance(dateNaissance);
        enseignant.setLieuNaissance(lieuNaissance);


        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantConditionP(Long id, StatutMedical statutMedical) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setStatutMedical(statutMedical);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantOrigine(Long id, Region region, Departement departement, Arrondissement arrondissement) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setRegionOrigine(region);
        enseignant.setDepartementOrigine(departement);
        enseignant.setArrondissementOrigine(arrondissement);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantFamille(Long id, StatutMatrimonial statutMatrimonial, Integer nombreEnfant) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setStatutMatrimonial(statutMatrimonial);
        enseignant.setNombreEnfant(nombreEnfant);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantContact(Long id, String telephone, String email) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setTelephone(telephone);
        enseignant.setEmail(email);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantFormation(Long id, Formation formation, Discipline discipline, Diplome dernierDiplome) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setFormation(formation);
        enseignant.setDiscipline(discipline);
        enseignant.getDiplomes().add(dernierDiplome);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantCarriere(Long id, String matricule, Categorie categorie, Statut statut, LocalDate dateEntreeService, Diplome diplomeEntree, Grade grade, String langueTravail) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setMatricule(matricule);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public EnseignantDto updateEnseignantAffectation(Long id, Poste poste, String rang, LocalDate dateAffectation, String referenceAffectation, LocalDate datePriseService, Presence presence, Etablissement etablissement) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        enseignant.setPresence(presence);

        Enseignant updated = repository.save(enseignant);
        return dtoMapper.apply(updated);
    }

    @Override
    public void deleteEnseignant(Long id) {

        Enseignant enseignant = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );
        repository.delete(enseignant);

    }

    @Override
    public void deleteEnseignant(String matricule) {

        Enseignant enseignant = repository.findEnseignantByMatricule(matricule).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "matricule", matricule)
        );
        repository.delete(enseignant);

    }

}
