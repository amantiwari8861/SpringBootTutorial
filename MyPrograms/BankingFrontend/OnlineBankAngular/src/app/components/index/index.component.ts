import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
// import { cssworkspace } from "../../../assets/vendor/";
// import "../../../assets/vendor/bootstrap/js/bootstrap.js"
// import "node_modules/bootstrap/dist/js/bootstrap.js"

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css',
  "../../../assets/vendor/animate.css/animate.min.css",
  "../../../assets/vendor/aos/aos.css",
  // "../../../assets/vendor/bootstrap/css/bootstrap.min.css",
  "../../../assets/vendor/bootstrap-icons/bootstrap-icons.css",
  "../../../assets/vendor/boxicons/css/boxicons.min.css",
  "../../../assets/vendor/glightbox/css/glightbox.min.css",
  "../../../assets/vendor/remixicon/remixicon.css",
  "../../../assets/vendor/swiper/swiper-bundle.min.css",
  "../../../assets/css/mystyle.css"
]
})
export class IndexComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  posts: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.dtOptions = {
      serverSide:true,
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true
    };

    this.http.get('http://jsonplaceholder.typicode.com/posts')
      .subscribe(posts => {
        this.posts = posts;
      });
  }
}
