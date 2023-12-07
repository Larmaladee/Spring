package com.example.demo1.Controllers;

import com.example.demo1.Models.*;
import com.example.demo1.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AllController {

    @Autowired
    private typeRepo typeRepos;
    @Autowired
    private roleRepo roleRepos;
    @Autowired
    private priorRepos priorReposs;
    @Autowired
    private statRepo statRepos;
    @Autowired
    private userRepo userRepos;
    @Autowired
    private projectRepo projectRepos;
    @Autowired
    private taskRepo taskRepos;
    @Autowired
    private commRepo commRepos;



    @GetMapping("/Comments")
    public String getcom(Model model) {
        Iterable<Comments> personal = commRepos.findAll();
        model.addAttribute("comments", personal);
        return "CommentsPage";
    }

    @GetMapping("/Personal")
    public String getper(Model model) {
        Iterable<Personal> personal = userRepos.findAll();
        model.addAttribute("personales", personal);
        return "PersonalPage";
    }

    @GetMapping("/Projects")
    public String getprj(Model model) {
        Iterable<Projects> role = projectRepos.findAll();
        model.addAttribute("projects", role);
        return "ProjectsPage";
    }

    @GetMapping("/Role")
    public String getrole(Model model) {
        Iterable<Role> role = roleRepos.findAll();
        model.addAttribute("roles", role);
        return "RolePage";
    }
    @GetMapping("/Task_priorities")
    public String getprio(Model model) {
        Iterable<Task_priorities> task_prioritie = priorReposs.findAll();
        model.addAttribute("task_priorities", task_prioritie);
        return "Task_prioritiesPage";
    }
    @GetMapping("/Task_statuses")
    public String getstatus(Model model) {
        Iterable<Task_statuses> task_status = statRepos.findAll();
        model.addAttribute("task_statuses", task_status);
        return "Task_statusesPage";
    }
    @GetMapping("/Task")
    public String gettask(Model model) {
        Iterable<Tasks> task = taskRepos.findAll();
        model.addAttribute("tasks", task);
        return "TaskPage";
    }

    @GetMapping("/Type")
    public String gettype(Model model) {
        Iterable<Type> type = typeRepos.findAll();
        model.addAttribute("types", type);
        return "TypePage";
    }


    @PostMapping("/Type")
    public String addType(@ModelAttribute("types") @Valid Type type,Model model,
                          @RequestParam String category_name){
        type.setCategory_name(category_name);
        typeRepos.save(type);
        Iterable<Type> typee = typeRepos.findAll();
        model.addAttribute("types", typee);
        return "TypePage";
    }

    @PatchMapping("/Type")
    public String updateType(@ModelAttribute("types") Type type, Model model, String category_idUP, String category_nameUP){
        Long rait = Long.parseLong(category_idUP);

        Optional<Type> optionalUser = typeRepos.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Type typee = optionalUser.get();
            typee.setCategory_name(category_nameUP);
            typeRepos.save(typee);
        }

        Iterable<Type> typeee = typeRepos.findAll();
        model.addAttribute("types", typeee);

        return "TypePage";
    }

    @DeleteMapping("/Type")
    public String deleteType(Model model, String category_idDel){
        Long intid = Long.parseLong(category_idDel);
        Optional<Type> optionalUser = typeRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Type typee = optionalUser.get();
            typeRepos.delete(typee);
        }
        Iterable<Type> typeee = typeRepos.findAll();
        model.addAttribute("types", typeee);
        return "TypePage";
    }

    @PostMapping("/Role")
    public String addRole(@ModelAttribute("roles") @Valid Role role,Model model,
                          @RequestParam String role_name){
        role.setRole_name(role_name);
        roleRepos.save(role);
        Iterable<Role> typee = roleRepos.findAll();
        model.addAttribute("roles", typee);
        return "RolePage";
    }

    @PatchMapping("/Role")
    public String updateRole(@ModelAttribute("roles") Role role, Model model, String role_idUP, String role_nameUP){
        Long rait = Long.parseLong(role_idUP);

        Optional<Role> optionalUser = roleRepos.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Role typee = optionalUser.get();
            typee.setRole_name(role_nameUP);
            roleRepos.save(typee);
        }

        Iterable<Role> typeee = roleRepos.findAll();
        model.addAttribute("roles", typeee);

        return "RolePage";
    }

    @DeleteMapping("/Role")
    public String deleteRole(Model model, String role_idDel){
        Long intid = Long.parseLong(role_idDel);
        Optional<Role> optionalUser = roleRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Role typee = optionalUser.get();
            roleRepos.delete(typee);
        }
        Iterable<Role> typeee = roleRepos.findAll();
        model.addAttribute("roles", typeee);
        return "RolePage";
    }

    @PostMapping("/Task_priorities")
    public String addPrior(@ModelAttribute("Task_priorities") @Valid Task_priorities type,Model model,
                          @RequestParam String priority_name){
        type.setPriority_name(priority_name);
        priorReposs.save(type);
        Iterable<Task_priorities> typee = priorReposs.findAll();
        model.addAttribute("task_priorities", typee);
        return "Task_prioritiesPage";
    }

    @PatchMapping("/Task_priorities")
    public String updatePrior(@ModelAttribute("Task_priorities") Task_priorities type, Model model, String priority_idUP, String priority_nameUP){
        Long rait = Long.parseLong(priority_idUP);

        Optional<Task_priorities> optionalUser = priorReposs.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Task_priorities typee = optionalUser.get();
            typee.setPriority_name(priority_nameUP);
            priorReposs.save(typee);
        }

        Iterable<Task_priorities> typeee = priorReposs.findAll();
        model.addAttribute("task_priorities", typeee);

        return "Task_prioritiesPage";
    }

    @DeleteMapping("/Task_priorities")
    public String deletePrior(Model model, String priority_idDel){
        Long intid = Long.parseLong(priority_idDel);
        Optional<Task_priorities> optionalUser = priorReposs.findById(intid);
        if (optionalUser.isPresent()) {
            Task_priorities typee = optionalUser.get();
            priorReposs.delete(typee);
        }
        Iterable<Task_priorities> typeee = priorReposs.findAll();
        model.addAttribute("task_priorities", typeee);
        return "Task_prioritiesPage";
    }

    @PostMapping("/Task_statuses")
    public String addStat(@ModelAttribute("task_statuses") @Valid Task_statuses type,Model model,
                          @RequestParam String status_name){
        type.setStatus_name(status_name);
        statRepos.save(type);
        Iterable<Task_statuses> typee = statRepos.findAll();
        model.addAttribute("task_statuses", typee);
        return "Task_statusesPage";
    }

    @PatchMapping("/Task_statuses")
    public String updateStat(@ModelAttribute("task_statuses") Task_statuses type, Model model, String status_idUP, String status_nameUP){
        Long rait = Long.parseLong(status_idUP);

        Optional<Task_statuses> optionalUser = statRepos.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Task_statuses typee = optionalUser.get();
            typee.setStatus_name(status_nameUP);
            statRepos.save(typee);
        }

        Iterable<Task_statuses> typeee = statRepos.findAll();
        model.addAttribute("task_statuses", typeee);

        return "Task_statusesPage";
    }

    @DeleteMapping("/Task_statuses")
    public String deleteStat(Model model, String status_idDel){
        Long intid = Long.parseLong(status_idDel);
        Optional<Task_statuses> optionalUser = statRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Task_statuses typee = optionalUser.get();
            statRepos.delete(typee);
        }
        Iterable<Task_statuses> typeee = statRepos.findAll();
        model.addAttribute("task_statuses", typeee);
        return "Task_statusesPage";
    }

    @PostMapping("/Personal")
    public String addPers(@ModelAttribute("personales") @Valid Personal type,Model model,
                          @RequestParam String username, @RequestParam String password, @RequestParam String role){
        type.setUsername(username);
        type.setPassword(password);
        type.setRole(role);
        userRepos.save(type);
        Iterable<Personal> personal = userRepos.findAll();
        model.addAttribute("personales", personal);
        return "PersonalPage";
    }

    @PatchMapping("/Personal")
    public String updatePers(@ModelAttribute("personales") Personal type, Model model, String user_idUP, String usernameUP, String passwordUP, String role_idUP){
        Long rait = Long.parseLong(user_idUP);

        Optional<Personal> optionalUser = userRepos.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Personal typee = optionalUser.get();
            typee.setUsername(usernameUP);
            typee.setPassword(passwordUP);
            typee.setRole(role_idUP);
            userRepos.save(typee);
        }

        Iterable<Personal> personal = userRepos.findAll();
        model.addAttribute("personales", personal);

        return "PersonalPage";
    }

    @DeleteMapping("/Personal")
    public String deletePers(Model model, String user_idDel){
        Long intid = Long.parseLong(user_idDel);
        Optional<Personal> optionalUser = userRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Personal typee = optionalUser.get();
            userRepos.delete(typee);
        }
        Iterable<Personal> personal = userRepos.findAll();
        model.addAttribute("personales", personal);
        return "PersonalPage";
    }

    @PostMapping("/Projects")
    public String addProject(@ModelAttribute("projects") @Valid Projects type,Model model,
                          @RequestParam String project_name, @RequestParam String user_id){
        type.setProject_name(project_name);
        Long intid = Long.parseLong(user_id);
        Optional<Personal> optionalUser = userRepos.findById(intid);
        if (optionalUser.isPresent()) {
            type.setPersonal(optionalUser.get());
        }
        projectRepos.save(type);
        Iterable<Projects> typee = projectRepos.findAll();
        model.addAttribute("projects", typee);
        return "ProjectsPage";
    }

    @PatchMapping("/Projects")
    public String updateProject(@ModelAttribute("projects") Projects type, Model model, String project_idUP, String project_nameUP, String user_idUP){
        Long rait = Long.parseLong(project_idUP);

        Optional<Projects> optionalUser = projectRepos.findById(rait);

        if (optionalUser.isPresent()) {
            // Modify the fields of the entity object
            Projects typee = optionalUser.get();
            typee.setProject_name(project_nameUP);
            Long intid = Long.parseLong(user_idUP);
            Optional<Personal> optionalUserr = userRepos.findById(intid);
            if (optionalUser.isPresent()) {
                type.setPersonal(optionalUserr.get());
            }
            projectRepos.save(typee);
        }

        Iterable<Projects> typeee = projectRepos.findAll();
        model.addAttribute("projects", typeee);

        return "ProjectsPage";
    }

    @DeleteMapping("/Projects")
    public String deleteProject(Model model, String project_idDel){
        Long intid = Long.parseLong(project_idDel);
        Optional<Projects> optionalUser = projectRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Projects typee = optionalUser.get();
            projectRepos.delete(typee);
        }
        Iterable<Projects> typeee = projectRepos.findAll();
        model.addAttribute("projects", typeee);
        return "ProjectsPage";
    }

    @PostMapping("/Task")
    public String addTask(@ModelAttribute("tasks") @Valid Tasks type,Model model,
                          @RequestParam String title,@RequestParam String priority_id,@RequestParam String status_id,@RequestParam String project_id,@RequestParam String user_id){
        type.setTitle(title);
        Long intidUs = Long.parseLong(user_id);
        Long intidPrior = Long.parseLong(priority_id);
        Long intidStat = Long.parseLong(status_id);
        Long intidPrj = Long.parseLong(project_id);
        Optional<Personal> optionalUser = userRepos.findById(intidUs);
        if (optionalUser.isPresent()) {
            type.setPersonal(optionalUser.get());
        }
        Optional<Task_priorities> optionalPrior = priorReposs.findById(intidPrior);
        if (optionalUser.isPresent()) {
            type.setTask_priorities(optionalPrior.get());
        }
        Optional<Task_statuses> optionalStat = statRepos.findById(intidStat);
        if (optionalUser.isPresent()) {
            type.setTask_statuses(optionalStat.get());
        }
        Optional<Projects> optionalProj = projectRepos.findById(intidPrj);
        if (optionalUser.isPresent()) {
            type.setProjects(optionalProj.get());
        }
        taskRepos.save(type);
        Iterable<Tasks> typee = taskRepos.findAll();
        model.addAttribute("tasks", typee);
        return "TaskPage";
    }

    @PatchMapping("/Task")
    public String updateTask(@ModelAttribute("tasks") Type type, Model model, String task_idUP, String titleUP, String priority_idUP, String status_idUP, String project_idUP, String user_idUP){
        Long rait = Long.parseLong(task_idUP);

        Optional<Tasks> optionalTasks = taskRepos.findById(rait);

        if (optionalTasks.isPresent()) {
            // Modify the fields of the entity object
            Tasks typee = optionalTasks.get();
            typee.setTitle(titleUP);
            Long intidUs = Long.parseLong(user_idUP);
            Long intidPrior = Long.parseLong(priority_idUP);
            Long intidStat = Long.parseLong(status_idUP);
            Long intidPrj = Long.parseLong(project_idUP);
            Optional<Personal> optionalUser = userRepos.findById(intidUs);
            if (optionalUser.isPresent()) {
                typee.setPersonal(optionalUser.get());
            }
            Optional<Task_priorities> optionalPrior = priorReposs.findById(intidPrior);
            if (optionalUser.isPresent()) {
                typee.setTask_priorities(optionalPrior.get());
            }
            Optional<Task_statuses> optionalStat = statRepos.findById(intidStat);
            if (optionalUser.isPresent()) {
                typee.setTask_statuses(optionalStat.get());
            }
            Optional<Projects> optionalProj = projectRepos.findById(intidPrj);
            if (optionalUser.isPresent()) {
                typee.setProjects(optionalProj.get());
            }
            taskRepos.save(typee);
        }

        Iterable<Tasks> typeee = taskRepos.findAll();
        model.addAttribute("tasks", typeee);

        return "TaskPage";
    }

    @DeleteMapping("/Task")
    public String deleteTask(Model model, String task_idDel){
        Long intid = Long.parseLong(task_idDel);
        Optional<Tasks> optionalUser = taskRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Tasks typee = optionalUser.get();
            taskRepos.delete(typee);
        }
        Iterable<Tasks> typeee = taskRepos.findAll();
        model.addAttribute("tasks", typeee);
        return "TaskPage";
    }

    @PostMapping("/Comments")
    public String addComm(@ModelAttribute("comments") @Valid Comments type,Model model,
                          @RequestParam String comment_text,@RequestParam String task_id,@RequestParam String user_id){
        type.setComment_text(comment_text);
        Long intidUs = Long.parseLong(user_id);
        Long intidTask = Long.parseLong(task_id);
        Optional<Personal> optionalUser = userRepos.findById(intidUs);
        if (optionalUser.isPresent()) {
            type.setPersonal(optionalUser.get());
        }
        Optional<Tasks> optionalPrior = taskRepos.findById(intidTask);
        if (optionalUser.isPresent()) {
            type.setTasks(optionalPrior.get());
        }
        commRepos.save(type);
        Iterable<Comments> typee = commRepos.findAll();
        model.addAttribute("comments", typee);
        return "CommentsPage";
    }

    @PatchMapping("/Comments")
    public String updateComm(@ModelAttribute("comments") Type type, Model model, String comment_idUP, String comment_textUP, String task_idUP, String user_idUP){
        Long rait = Long.parseLong(comment_idUP);

        Optional<Comments> optionalTasks = commRepos.findById(rait);

        if (optionalTasks.isPresent()) {
            // Modify the fields of the entity object
            Comments typee = optionalTasks.get();
            typee.setComment_text(comment_textUP);
            Long intidUs = Long.parseLong(user_idUP);
            Long intidPrior = Long.parseLong(task_idUP);
            Optional<Personal> optionalUser = userRepos.findById(intidUs);
            if (optionalUser.isPresent()) {
                typee.setPersonal(optionalUser.get());
            }
            Optional<Tasks> optionalPrior = taskRepos.findById(intidPrior);
            if (optionalUser.isPresent()) {
                typee.setTasks(optionalPrior.get());
            }
            commRepos.save(typee);
        }

        Iterable<Comments> typeee = commRepos.findAll();
        model.addAttribute("comments", typeee);

        return "CommentsPage";
    }

    @DeleteMapping("/Comments")
    public String deleteComm(Model model, String comment_idDel){
        Long intid = Long.parseLong(comment_idDel);
        Optional<Comments> optionalUser = commRepos.findById(intid);
        if (optionalUser.isPresent()) {
            Comments typee = optionalUser.get();
            commRepos.delete(typee);
        }
        Iterable<Comments> typeee = commRepos.findAll();
        model.addAttribute("comments", typeee);
        return "CommentsPage";
    }
}
