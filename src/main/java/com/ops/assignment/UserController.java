package com.ops.assignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LogManager.getLogger(UserController.class);

    /**
     * /create --> Create a new user and save it in the database.
     *
     * @param lastName
     *            User's email
     * @param firstName
     *            User's name
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String lastName, String firstName) {
        logger.info("received create-request with lastName " + lastName + " and first name " + firstName);
        User user = null;
        try {
            user = new User(lastName, firstName);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    /**
     * /delete --> Delete the user having the passed id.
     *
     * @param id
     *            The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        logger.info("received delete-request with id " + id);
        try {
            User user = new User(id);
            userRepository.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * /show --> show all users in the database. just for demonstration. Of
     * course this could be made nicer!
     *
     * @return A string that contains all the users in the database.
     */
    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        logger.info("received show-request");
        Iterable<User> users = null;
        try {
            users = userRepository.findAll();
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }

        String usersStringified = "<table border='1'><tr><td>id</td><td>First name</td><td>Last Name</td></tr>";
        for (User user : users) {
            usersStringified += "<tr><td>" + user.getId() + "</td><td>" + user.getFirstName() + "</td><td>" + user.getLastName()
                    + "</td></tr>";
        }
        usersStringified += "</table>";
        return usersStringified;
    }
}
