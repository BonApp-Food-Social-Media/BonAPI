package ch.bonapp.bonapi.services;

import ch.bonapp.bonapi.entities.both.User;
import ch.bonapp.bonapi.entities.both.UserFollowing;
import ch.bonapp.bonapi.repositories.BonAPI_UserFollowing_Repository;
import ch.bonapp.bonapi.repositories.BonAPI_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Service class for managing User entities.
 * Provides methods for CRUD operations, managing followers, and custom queries related to Users.
 */
@Service
public class BonAPI_User_Service {

    @Autowired
    private BonAPI_User_Repository userRepository;

    @Autowired
    private BonAPI_UserFollowing_Repository userFollowingRepository;

    /**
     * Saves or updates a User entity in the database.
     * @param user The User entity to be saved or updated.
     * @return The saved or updated User entity.
     * @throws IllegalArgumentException if the User or username is null.
     */
    public User saveUser(User user) {
        if (user == null || user.getUsername() == null) {
            throw new IllegalArgumentException("User or username cannot be null.");
        }
        return userRepository.save(user);
    }

    /**
     * Retrieves all User entities from the database.
     * @return A list of all User entities.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a User entity by its ID.
     * @param id The ID of the User entity.
     * @return The User entity if found.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the User with the given ID is not found.
     */
    public User getUserById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found."));
    }

    /**
     * Deletes a User entity by its ID.
     * @param id The ID of the User entity to delete.
     * @throws IllegalArgumentException if the ID is null or empty.
     * @throws RuntimeException if the User with the given ID does not exist.
     */
    public void deleteUserById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }

    /**
     * Retrieves a User entity by its username.
     * @param username The username of the User entity.
     * @return The User entity if found.
     * @throws IllegalArgumentException if the username is null or empty.
     * @throws RuntimeException if the User with the given username is not found.
     */
    public User getUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        return userRepository.findByUsername(username);
    }

    /**
     * Adds a follower relationship between two users.
     * @param followerId The ID of the user who is following.
     * @param followedId The ID of the user being followed.
     */
    public void addFollower(String followerId, String followedId) {
        if (followerId.equals(followedId)) {
            throw new IllegalArgumentException("Users cannot follow themselves.");
        }
        UserFollowing newFollow = new UserFollowing(followerId, followedId);
        userFollowingRepository.save(newFollow);
    }

    /**
     * Removes a follower relationship between two users.
     * @param followerId The ID of the user who is unfollowing.
     * @param followedId The ID of the user being unfollowed.
     */
    public void removeFollower(String followerId, String followedId) {
        userFollowingRepository.deleteByFollowerIdAndFollowedId(followerId, followedId);
    }

    /**
     * Retrieves all followers of a specific user.
     * @param userId The ID of the user whose followers are being queried.
     * @return A list of Users who are followers of the specified user.
     */
    public List<User> getFollowers(String userId) {
        List<UserFollowing> followers = userFollowingRepository.findByFollowedId(userId);
        List<User> followerUsers = followers.stream()
                .map(follower -> userRepository.findById(follower.getFollowerId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return followerUsers;
    }

    /**
     * Retrieves all users that a specific user is following.
     * @param userId The ID of the user whose followings are being queried.
     * @return A list of Users that the specified user is following.
     */
    public List<User> getFollowings(String userId) {
        List<UserFollowing> followings = userFollowingRepository.findByFollowerId(userId);
        List<User> followingUsers = followings.stream()
                .map(following -> userRepository.findById(following.getFollowedId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return followingUsers;
    }
}
