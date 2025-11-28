import axios from 'axios';

const API = 'http://localhost:8080/api'; // backend

// Récupérer la liste des joueurs
export const getPlayers = async () => {
  try {
    const response = await axios.get(`${API}/players`);
    return response.data; // renvoie directement le tableau de joueurs
  } catch (err) {
    console.error('Erreur fetching players:', err);
    return [];
  }
};

// Récupérer la liste des parties
export const getParties = async () => {
  try {
    const response = await axios.get(`${API}/parties`);
    return response.data; // renvoie directement le tableau de parties
  } catch (err) {
    console.error('Erreur fetching parties:', err);
    return [];
  }
};