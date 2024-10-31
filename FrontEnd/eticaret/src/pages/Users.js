import React, { useEffect, useState } from 'react';
import api from '../services/api';

const Users = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // API'den tüm kullanıcıları al
    api.get('/users')
      .then(response => setUsers(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h1>Kullanıcılar</h1>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.username} - {user.email}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Users;
