package cs.vapo.bringit.core.dao.user;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.mapper.MapperUtils;
import cs.vapo.bringit.core.dao.model.UserDM;
import cs.vapo.bringit.core.dao.model.UserForLoginDM;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@DataService
public class UserDataService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    /**
     * Returns the {@link UserForLoginDM} for login operations
     * @param username the username to look by
     * @return {@link UserForLoginDM} if found
     * @throws EntityNotFoundException if not found
     */
    public UserForLoginDM findUserByUsernameForLogin(final String username) throws EntityNotFoundException {
        final Optional<UserEntity> userEntity = repository.findUserByUsername(username);
        if (userEntity.isEmpty()) {
            throw new EntityNotFoundException(String.format("Could not find username %s", username));
        }
        return mapper.map(userEntity.get(), UserForLoginDM.class);
    }

    /**
     * Finds the user by the given id
     * @param userId the user id
     * @return {@link UserDM} the user
     * @throws EntityNotFoundException if user not found for the given id
     */
    public UserDM findUserById(final String userId) throws EntityNotFoundException {
        final Optional<UserEntity> userEntity = repository.findById(userId);
        if (userEntity.isEmpty()) {
            throw new EntityNotFoundException(String.format("Could not find user with id: %s", userId));
        }
        return mapper.map(userEntity.get(), UserDM.class);
    }

    /**
     * Creates the user given validated user data
     * @param userData validated user data
     * @return the user ID
     */
    public String createUser(final UserForLoginDM userData) {
        final UserEntity userEntity = mapper.map(userData, UserEntity.class);
        return repository.save(userEntity).getId();
    }

    /**
     * Updates a user with the provided user data
     * @param userId the user id to update
     * @param userData the updated user data
     * @return the user id
     */
    public String updateUser(final String userId, final UserForLoginDM userData) {
        final Optional<UserEntity> entityOptional = repository.findById(userId);
        if (entityOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("User with id: %s not found for operation update user.", userId));
        }
        final UserEntity existingUser = entityOptional.get();
        MapperUtils.mapNonNull(userData, existingUser, null);
        return existingUser.getId();
    }
}
