import React from "react";
import { useNavigate } from "react-router-dom";
import './Home.css';

const demoEmployees = [
  { empId: 18, name: "Varshedhaa V R" },
  { empId: 21, name: "Arun Rajasekaran" },
];

const EmployeeListDemo = () => {
  const navigate = useNavigate();

  return (
    <div style={{ minHeight: '100vh', background: 'linear-gradient(120deg, #74ebd5 0%, #9face6 100%)', padding: '40px' }}>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 24 }}>
        <h2 style={{ color: '#1976d2', fontWeight: 700 }}>EMS</h2>
        <div>
          <button style={{ background: '#ffe066', color: '#222', border: 'none', borderRadius: 6, padding: '8px 18px', marginRight: 8, fontWeight: 600 }}>Add</button>
          <button style={{ background: '#74c0fc', color: '#fff', border: 'none', borderRadius: 6, padding: '8px 18px', marginRight: 8, fontWeight: 600 }}>Employees</button>
          <button style={{ background: '#fa5252', color: '#fff', border: 'none', borderRadius: 6, padding: '8px 18px', fontWeight: 600 }}>Logout</button>
        </div>
      </div>
      <div style={{ maxWidth: 600, margin: '0 auto' }}>
        <input type="text" placeholder="Varshedhaa V R" style={{ width: '100%', padding: '12px', borderRadius: 6, border: '1px solid #ccc', marginBottom: 16 }} />
        <button style={{ background: '#1976d2', color: '#fff', border: 'none', borderRadius: 6, padding: '10px 32px', fontWeight: 600, marginBottom: 32 }}>Search</button>
        <div style={{ background: '#fff', borderRadius: 12, boxShadow: '0 2px 16px rgba(0,0,0,0.08)', padding: '32px' }}>
          <h2 style={{ textAlign: 'center', color: '#1976d2', fontWeight: 600, marginBottom: 24 }}>Employee List</h2>
          <table style={{ width: '100%', borderCollapse: 'collapse', marginBottom: 0 }}>
            <thead>
              <tr style={{ background: '#222', color: '#fff' }}>
                <th style={{ padding: '12px', fontWeight: 700 }}>ID</th>
                <th style={{ padding: '12px', fontWeight: 700 }}>Name</th>
                <th style={{ padding: '12px', fontWeight: 700 }}>Actions</th>
              </tr>
            </thead>
            <tbody>
              {demoEmployees.map(emp => (
                <tr key={emp.empId} style={{ background: '#f8f9fa' }}>
                  <td style={{ padding: '12px', color: '#222' }}>{emp.empId}</td>
                  <td style={{ padding: '12px' }}>
                    <a href="#" style={{ color: '#1976d2', textDecoration: 'none', fontWeight: 500 }}>{emp.name}</a>
                  </td>
                  <td style={{ padding: '12px' }}>
                    <button style={{ background: '#ffe066', color: '#222', border: 'none', borderRadius: 6, padding: '6px 16px', marginRight: 8, fontWeight: 600 }}>Edit</button>
                    <button style={{ background: '#fa5252', color: '#fff', border: 'none', borderRadius: 6, padding: '6px 16px', fontWeight: 600 }}>Delete</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default EmployeeListDemo;
