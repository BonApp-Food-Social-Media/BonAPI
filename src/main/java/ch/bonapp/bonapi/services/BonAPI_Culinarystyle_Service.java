package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.Culinarystyle;
import ch.bonapp.bonapi.repositories.BonAPI_Culinarystyle_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service class for managing CulinaryStyle entities.
 * This class provides methods for CRUD operations and custom queries related to CulinaryStyles.
 */
@Service
public class BonAPI_Culinarystyle_Service {

    /**
     * Repository for CulinaryStyle entities.
     * Used for accessing the database.
     */
    @Autowired
    private BonAPI_Culinarystyle_Repository culinaryStyleRepository;

    /**
     * Saves or updates a CulinaryStyle entity in the database.
     *
     * @param culinaryStyle The CulinaryStyle entity to be saved or updated.
     * @return The saved or updated CulinaryStyle entity.
     */
    public Culinarystyle saveCulinaryStyle(Culinarystyle culinaryStyle) {
        return culinaryStyleRepository.save(culinaryStyle);
    }

    /**
     * Retrieves all CulinaryStyle entities from the database.
     *
     * @return A list of all CulinaryStyle entities.
     */
    public List<Culinarystyle> getAllCulinaryStyles() {
        return culinaryStyleRepository.findAll();
    }

    /**
     * Retrieves a CulinaryStyle entity by its ID.
     *
     * @param id The ID of the CulinaryStyle entity.
     * @return An Optional containing the CulinaryStyle entity, if found.
     */
    public Optional<Culinarystyle> getCulinaryStyleById(String id) {
        return culinaryStyleRepository.findById(id);
    }

    /**
     * Deletes a CulinaryStyle entity by its ID.
     *
     * @param id The ID of the CulinaryStyle entity to delete.
     */
    public void deleteCulinaryStyleById(String id) {
        culinaryStyleRepository.deleteById(id);
    }

}
