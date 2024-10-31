import React, { useState, useEffect } from 'react';

const UsersList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // API'ye GET isteği atarak kullanıcıları getir
    fetch('http://localhost:8080/api/users')
      .then(response => response.json())
      .then(data => setUsers(data))
      .catch(error => console.error('Error:', error));
  }, []);

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.username} - {user.email}</li>
        ))}
      </ul>
    </div>
  );
};

export default UsersList;
