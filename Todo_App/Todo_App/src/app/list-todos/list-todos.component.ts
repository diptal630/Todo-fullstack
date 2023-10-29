import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';


export class Todo{
  constructor(
    public id : number,
    public description : string,
    public done : boolean,
    public targetDate : Date
  ){}
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})

export class ListTodosComponent implements OnInit {

  todos: Todo[] = [];
  message:string | undefined
    // [
    //   new Todo(1, 'Java' , true , new Date()),
    //   new Todo(2, 'Jenkins', false, new Date()),
    //   new Todo (3, 'Design Patterns' , false , new Date())
    // { id :1, description :'Learn with Java'},
    // {id:2 , description :'NetherLand'},
    // {id :3 , description : 'Aisa'}
    //]
  constructor(
    private todoService:TodoDataService,
    private router : Router
  ){}


  ngOnInit() {
    this.refreshTodo();
   
  }


  refreshTodo(){
    this.todoService.retrieveAllTodos('in28minutes').subscribe(
      response => {
      console.log(response)
      this.todos = response;
      }
    ) 
  }


  deleteTodo(id : number){
    console.log(`delete todo ${id}`);
    this.todoService.deleteTodo('in28minutes',id).subscribe(
      response=> {
        console.log(response);
        this.message = `Delete of Todo ${id} is Successful!`
        this.refreshTodo();
      }
    )
  }

  updateTodo(id:number){
    console.log(`update ${id}`);
    this.router.navigate(['todos',id]);
  }

  addTodo(){
    this.router.navigate(['todos',-1]);  
  }
}
