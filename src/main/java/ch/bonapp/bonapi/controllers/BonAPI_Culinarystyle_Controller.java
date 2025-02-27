package ch.bonapp.bonapi.controllers;

import ch.bonapp.bonapi.entities.both.Culinarystyle;
import ch.bonapp.bonapi.services.BonAPI_Culinarystyle_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing CulinaryStyle entities.
 * Provides endpoints for CRUD operations.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/culinarystyle")
public class BonAPI_Culinarystyle_Controller {

    /**
     * Service for CulinaryStyle entities.
     * Used to interact with the database through the service layer.
     */
    @Autowired
    private BonAPI_Culinarystyle_Service culinaryStyleService;

    /**
     * Retrieves all CulinaryStyle entities.
     *
     * @return A list of all CulinaryStyle entities.
     */
    @GetMapping
    public List<Culinarystyle> getAllCulinaryStyles() {
        return culinaryStyleService.getAllCulinaryStyles();
    }

    /**
     * Retrieves a CulinaryStyle entity by its ID.
     *
     * @param id The ID of the CulinaryStyle entity.
     * @return The CulinaryStyle entity if found.
     */
    @GetMapping("/{id}")
    public Optional<Culinarystyle> getCulinaryStyleById(@PathVariable String id) {
        return Optional.ofNullable(culinaryStyleService.getCulinaryStyleById(id));
    }

    /**
     * Creates a new CulinaryStyle entity.
     *
     * @param culinaryStyle The CulinaryStyle entity to create.
     * @return The created CulinaryStyle entity.
     */
    @PostMapping
    public Culinarystyle createCulinaryStyle(@RequestBody Culinarystyle culinaryStyle) {
        return culinaryStyleService.saveCulinaryStyle(culinaryStyle);
    }

    /**
     * Updates an existing CulinaryStyle entity.
     *
     * @param id             The ID of the CulinaryStyle entity to update.
     * @param culinaryStyle The updated CulinaryStyle entity.
     * @return The updated CulinaryStyle entity.
     */
    @PutMapping("/{id}")
    public Culinarystyle updateCulinaryStyle(@PathVariable String id, @RequestBody Culinarystyle culinaryStyle) {
        culinaryStyle.setId(id);
        return culinaryStyleService.saveCulinaryStyle(culinaryStyle);
    }

    /**
     * Deletes a CulinaryStyle entity by its ID.
     *
     * @param id The ID of the CulinaryStyle entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteCulinaryStyle(@PathVariable String id) {
        culinaryStyleService.deleteCulinaryStyleById(id);
    }
}
