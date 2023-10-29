import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent  implements OnInit{

  constructor(
    private todoService : TodoDataService,
    private activatedRouter : ActivatedRoute,
    private router : Router
  ){}

  id:number =0;
  todo:Todo; 

  ngOnInit(): void {
    this.id = this.activatedRouter.snapshot.params['id'];
    this.todo = new Todo(this.id,'',false,new Date());
    if(this.id!=-1){
      this.todoService.retrieveTodo('in28minutes',this.id)
      .subscribe(
        data => this.todo = data
      )
    }
  
  }


  saveTodo(){
    if(this.todo.id ==-1){
      //Create Todo
      this.todoService.createTodo('in28minutes',this.todo)
      .subscribe(
        data => {console.log(data)
        this.router.navigate(['todos'])
        }
      )
    }
    else{
      this.todoService.updateTodo('in28minutes',this.id,this.todo)
      .subscribe(
        data => {
        console.log(data)
        this.router.navigate(['todos'])
        }
      )
    }
  }
}
