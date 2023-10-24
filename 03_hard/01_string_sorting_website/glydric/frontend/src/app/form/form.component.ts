import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import axios, {AxiosResponse} from "axios";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent {
  formData = {
    values: "3;2;1",
    type: 'quicksort'
  };

  response = ""

  constructor(private http: HttpClient) {
  }

  private formattedData() {
    return {
      values: this.formData.values.split(";"),
      type: this.formData.type
    }
  }

  async submitForm() {
    const options = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

    try {
      const res: AxiosResponse<string> = await axios.post(
        'http://localhost:8080/',
        this.formattedData(),
        {
          method: "POST",
        });

      this.response = res.data
    } catch (error) {
      if (error instanceof Error) {
        this.response = error.message
      } else {
        this.response = 'unexpected error'
      }
    }
  }
}
