<label for="ruc">RUC</label>
<input type="text" name="ruc" id="ruc" value="${business.ruc}"/>
<p>
<label for="name">Nombre de la empresa</label>
<input type="text" name="name" id="name" value="${business.name}"/>
</p>
<label for="address">Direccion</label>
<input type="text" name="address" id="address" value="${business.address}"/>

<label for="phone">Telefono</label>
<input type="text" name="phone" id="phone" value="${business.phone}"/>

<label for="email">Email</label>
<input type="text" name="email" id="email" value="${business.email}"/>

<input type="hidden" value="index" name="action"/>
<button type="submit" class="btn btn-primary">Guardar Cambios</button>