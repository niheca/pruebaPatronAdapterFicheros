
# 📦 Convert API

Una API REST que procesa información personal, transforma formatos de fecha, calcula edad y genera archivos en distintos formatos.

---

## 📍 Endpoint

```
POST http://localhost:8080/api/v1/convert
```

---

## 📤 Request

### 📝 Body (JSON)

```json
{
  "name": "niheca",
  "lastName": "hernandez",
  "birthDate": "17/07/2003",
  "gender": "male",
  "typeOfFile": "csv"
}
```

### 🔐 Reglas:

- `gender`: debe ser uno de los siguientes valores:
    - `"male"`
    - `"female"`
    - `"other"`

- `typeOfFile`: define el formato de salida del archivo, y debe ser uno de:
    - `"json"`
    - `"excel"`
    - `"csv"`
    - `"xml"`

---

## 📥 Response

La respuesta será generada **siguiendo este formato**, independientemente del tipo de archivo:

```json
{
  "fullName": "niheca hernandez",
  "formattedBirthDate": "2003-07-17",
  "age": 21,
  "gender": "M"
}
```

### 📌 Campos:

- `fullName`: combinación de `name` y `lastName`.
- `formattedBirthDate`: transforma la fecha de `dd/MM/yyyy` a `yyyy-MM-dd`.
- `age`: edad calculada en base a la fecha de nacimiento.
- `gender`:
    - `"M"` → male
    - `"F"` → female
    - `"X"` → other

---

## 🗃️ Tipo de archivo generado

Según el valor de `typeOfFile`, la respuesta será generada en ese formato (`json`, `excel`, `csv`, `xml`) y se guardará en el siguiente directorio:

```
📁 src/main/resources/generatedFiles/
```

---

## ✅ Ejemplo completo

### Request:

```json
{
  "name": "niheca",
  "lastName": "hernandez",
  "birthDate": "17/07/2003",
  "gender": "male",
  "typeOfFile": "csv"
}
```

### Response (en JSON):

```json
{
  "fullName": "niheca hernandez",
  "formattedBirthDate": "2003-07-17",
  "age": 21,
  "gender": "M"
}
```

---

## 📎 Notas

- El archivo generado se guarda automáticamente.
- No se retorna el archivo en la respuesta, pero queda disponible para su descarga o uso posterior en el servidor.

---

🛠️ ¡Fácil, limpio y extensible!
