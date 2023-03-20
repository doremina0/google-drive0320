<template>

    <v-card outlined>
        <v-card-title>
            DashBoard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Filename" v-model="item.filename" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Filesize" v-model="item.filesize" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Path" v-model="item.path" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Filetype" v-model="item.filetype" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsIndexed" v-model="item.isIndexed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsUploaded" v-model="item.isUploaded" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Url" v-model="item.url" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashBoardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashBoards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

