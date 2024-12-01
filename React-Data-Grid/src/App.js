import React, { Component } from 'react';
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-balham.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rowData: [
        { rollno: '001', name: 'Akash', dept: 'Cse' },
        { rollno: '002', name: 'Vysh', dept: 'Ai' },
        { rollno: '003', name: 'Doraemon', dept: 'Cse' },
        { rollno: '001', name: 'Akash', dept: 'Cse' },
        { rollno: '002', name: 'Vysh', dept: 'Ai' },
        { rollno: '003', name: 'Doraemon', dept: 'Cse' },
        { rollno: '001', name: 'Akash', dept: 'Cse' },
        { rollno: '002', name: 'Vysh', dept: 'Ai' },
        { rollno: '003', name: 'Doraemon', dept: 'Cse' },
        { rollno: '001', name: 'Akash', dept: 'Cse' },
        { rollno: '002', name: 'Vysh', dept: 'Ai' },
        { rollno: '003', name: 'Doraemon', dept: 'Cse' },
        { rollno: '001', name: 'Akash', dept: 'Cse' },
        { rollno: '002', name: 'Vysh', dept: 'Ai' },
        { rollno: '003', name: 'Doraemon', dept: 'Cse' },
      ],
      columnDefs: [
        { field: 'rollno', headerName: 'Roll Number', sortable: true, filter: true },
        { field: 'name', headerName: 'Name', sortable: true, filter: true },
        { field: 'dept', headerName: 'Department', sortable: true, filter: true },
      ],
    };
  }

  render() {
    return (
      <div className="ag-theme-balham" style={{ height: '200px', width: '600px' }}>
        <AgGridReact

        pagination={true}
          rowData={this.state.rowData}
          columnDefs={this.state.columnDefs}
          defaultColDef={{
            resizable: true, // Make all columns resizable
            flex: 1,         // Automatically adjust column widths
          }}
        />
      </div>
    );
  }
}

export default App;
