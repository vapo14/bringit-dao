package cs.vapo.bringit.core.dao.user;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.mapper.MapperUtils;
import cs.vapo.bringit.core.dao.model.UserDM;
import cs.vapo.bringit.core.dao.model.UserForLoginDM;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@DataService
public class UserDataService {

    private final UserRepository repository;

    private final ContactRepository contactRepository;

    private final ModelMapper mapper;

    @Autowired
    public UserDataService(final UserRepository repository, final ModelMapper modelMapper,
                           final ContactRepository contactRepository) {
        this.repository = repository;
        this.mapper = modelMapper;
        this.contactRepository = contactRepository;
    }

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
    public UserDM findUserById(final long userId) throws EntityNotFoundException {
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
    public long createUser(final UserForLoginDM userData) {
        final UserEntity userEntity = mapper.map(userData, UserEntity.class);
        return repository.save(userEntity).getId();
    }

    /**
     * Updates a user with the provided user data
     * @param userId the user id to update
     * @param userData the updated user data
     * @return the user id
     */
    public long updateUser(final long userId, final UserForLoginDM userData) {
        final Optional<UserEntity> entityOptional = repository.findById(userId);
        if (entityOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("User with id: %s not found for operation update user.", userId));
        }
        final UserEntity existingUser = entityOptional.get();
        MapperUtils.mapNonNull(userData, existingUser, null);
        return existingUser.getId();
    }

    /**
     * Deletes a user given the userId
     * @param userId the userId to delete
     */
    public void deleteUser(final long userId) {
        repository.deleteById(userId);
    }

    /**
     * Adds a new contact to the provided user's list
     * @param userId the user that is adding a new contact
     * @param contactId the contact to add
     */
    public void addContact(final long userId, final long contactId) {
        final Optional<UserEntity> userOptional = repository.findById(userId);
        final Optional<UserEntity> contactOptional = repository.findById(contactId);
        if (userOptional.isEmpty() || contactOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("User with id: %s not found for operation add contact", userId));
        }
        final ContactEntity contactEntity = new ContactEntity();
        contactEntity.setUser(userOptional.get());
        contactEntity.setContact(contactOptional.get());
        contactRepository.save(contactEntity);
    }

    /**
     * Retrieves a list of the user's contacts
     * @param userId the user to lookup
     * @return the list of contacts
     */
    public List<UserDM> retrieveUserContacts(final long userId, final Pageable pageable) {
        final List<ContactEntity> contactEntities = contactRepository.findContactsByUserId(userId, pageable);
        final List<UserEntity> contacts = contactEntities.stream().map(ContactEntity::getContact).toList();
        return MapperUtils.mapList(contacts, UserDM.class);
    }
    /**
     * Returns the {@link UserDM} for the given username
     * @param username the username to look by
     * @return {@link UserDM} if found
     * @throws EntityNotFoundException if not found
     */
    public UserDM findUserByUsername(final String username) throws EntityNotFoundException {
        final Optional<UserEntity> optionalUser = repository.findUserByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException(String.format("No user found with username %s", username));
        }
        return mapper.map(optionalUser.get(), UserDM.class);
    }
}
