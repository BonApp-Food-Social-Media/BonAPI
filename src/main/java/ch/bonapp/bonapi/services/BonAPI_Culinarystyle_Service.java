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
        if (culinaryStyle == null || culinaryStyle.getStyle() == null) {
            throw new IllegalArgumentException("CulinaryStyle or style cannot be null.");
        }
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
     * @return The CulinaryStyle entity, if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the CulinaryStyle with the given ID is not found.
     */
    public Culinarystyle getCulinaryStyleById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }

        return culinaryStyleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CulinaryStyle with ID " + id + " not found."));
    }

    /**
     * Deletes a CulinaryStyle entity by its ID.
     *
     * @param id The ID of the CulinaryStyle entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     */
    public void deleteCulinaryStyleById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }

        if (!culinaryStyleRepository.existsById(id)) {
            throw new RuntimeException("CulinaryStyle with ID " + id + " does not exist.");
        }

        culinaryStyleRepository.deleteById(id);
    }

    /**
     * Searches for CulinaryStyles by their style.
     *
     * @param style The style to search for.
     * @return A list of matching CulinaryStyles.
     */
    public List<Culinarystyle> searchByStyle(String style) {
        if (style == null || style.isEmpty()) {
            throw new IllegalArgumentException("Style cannot be null or empty.");
        }

        return culinaryStyleRepository.findByStyle(style);
    }
}
